package lv.javaguru.businesslogic;


import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static lv.javaguru.domain.SubscriberBuilder.createSubscriber;

@Component
public class BusinessLogicImpl implements BusinessLogic {

    private AddSubscriberValidator addSubscriberValidator;
    private SubscriberDAO subscriberDAO;

    @Autowired
    public BusinessLogicImpl(SubscriberDAO subscriberDAO,
                             AddSubscriberValidator addSubscriberValidator){
        this.subscriberDAO = subscriberDAO;
        this.addSubscriberValidator = addSubscriberValidator;
    }

    @Override
    public Response addSubscriber(String firstName, String lastName, String personalID, Double balance) {
        List<Error> validationErrors = addSubscriberValidator.validate(firstName, lastName, personalID, balance);
        if(!validationErrors.isEmpty()){
            return Response.createFailResponse(validationErrors);
        }

        Subscriber subscriber = createSubscriber()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withPersonalID(personalID)
                .withBalance(balance).build();

        subscriberDAO.save(subscriber);

        return Response.createSuccessResponse();

    }

    @Override
    public boolean removeSubscriberByAccountNo(Long accountNo) {
        Optional<Subscriber> foundProduct = subscriberDAO.getByAccountNo(accountNo);
        if (foundProduct.isPresent()) {
            Subscriber subscriber = foundProduct.get();
            subscriberDAO.delete(subscriber);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Subscriber> getAllSubscribers() {
        return subscriberDAO.getAll();
    }

    private boolean alreadyExist(Subscriber subscriber) {
        return subscriberDAO.equals(subscriber.getPersonalID());
    }
}
