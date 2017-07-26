package businesslogic;


import database.Database;
import domain.Subscriber;

import java.security.Provider;
import java.util.List;
import java.util.Optional;

import static domain.SubscriberBuilder.createSubscriber;

public class BusinessLogicImpl implements BusinessLogic {

    private Database database;
    private AddSubscriberValidator addSubscriberValidator;

    public BusinessLogicImpl(Database database,
                             AddSubscriberValidator addSubscriberValidator){
        this.database = database;
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

        database.addSubscriber(subscriber);

        return Response.createSuccessResponse();

    }

    @Override
    public boolean removeSubscriberByAccountNo(int accountNo) {
        Optional<Subscriber> foundProduct = database.getSubscriberByAccountNo(accountNo);
        if (foundProduct.isPresent()) {
            Subscriber subscriber = foundProduct.get();
            database.deleteSubscriber(subscriber);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Subscriber> getAllSubscribers() {
        return database.getAllSubscribers();
    }

    private boolean alreadyExist(Subscriber subscriber) {
        return database.getSubscriberByPersonalID(subscriber.getPersonalID()).isPresent();
    }
}
