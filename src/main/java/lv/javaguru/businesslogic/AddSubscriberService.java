package lv.javaguru.businesslogic;

import lv.javaguru.businesslogic.api.*;
import lv.javaguru.businesslogic.api.Error;
import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

import static lv.javaguru.domain.SubscriberBuilder.createSubscriber;

public interface AddSubscriberService {

    Response addSubscriber(String firstName, String lastName, String personalID, Double balance);

}

@Component
class AddSubscriberServiceImpl implements AddSubscriberService {

    @Autowired private SubscriberDAO dao;
    @Autowired private AddSubscriberValidator addSubscriberValidator;

    @Override
    @Transactional
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

        dao.save(subscriber);

        return Response.createSuccessResponse();

    }
}
