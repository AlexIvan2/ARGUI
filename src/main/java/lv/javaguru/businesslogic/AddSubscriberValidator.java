package lv.javaguru.businesslogic;


import com.google.common.collect.Lists;
import lv.javaguru.database.SubscriberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

@Component
public class AddSubscriberValidator {

    //private Database lv.javaguru.database;
    private SubscriberDAO subscriberDAO;

    @Autowired
    public AddSubscriberValidator(SubscriberDAO subscriberDAO){
        this.subscriberDAO = subscriberDAO;
    }

    private boolean alreadyExist(String personalId) {
        return subscriberDAO.getByPersonalId(personalId).isPresent();
    }

    public List<Error> validate(String firstName, String lastName, String personalID, Double balance){
        List<Error> errors = Lists.newArrayList();
        validateFirstName(firstName).ifPresent(e -> errors.add(e));
        validateLastName(lastName).ifPresent(e -> errors.add(e));
        validatePersonalId(personalID).ifPresent(e -> errors.add(e));
        validateBalance(balance).ifPresent(e -> errors.add(e));
        return errors;
    }

    private Optional<Error> validateFirstName(String firstName){
        if (firstName == null || "".equals(firstName)) {
            return Optional.of(new Error("firstName", "Must be not empty"));
        } else if (firstName.matches(".*\\d.*")){
            return Optional.of(new Error("firstName", "Should not contain numbers"));
        } else{
            return Optional.empty();
        }
    }

    private Optional<Error> validateLastName(String lastName){
        if (lastName == null || "".equals(lastName)) {
            return Optional.of(new Error("lastName", "Must be not empty"));
        } else if (lastName.matches(".*\\d.*")){
            return Optional.of(new Error("lastName", "Should not contain numbers"));
        } else{
            return Optional.empty();
        }
    }

    private Optional<Error> validatePersonalId(String personalID){
        //Pattern pattern = Pattern.compile("^\\d{6}-\\d{5}");

        if (personalID == null || "".equals(personalID)) {
            return Optional.of(new Error("lastName", "Must be not empty"));
        } else if (!personalID.matches("^\\d{6}-\\d{5}$")){
            return Optional.of(new Error("personalID", "Formatting errors"));
        } else{
            DateFormat format = new SimpleDateFormat("ddMMyy");

            try{
                format.parse(personalID.substring(0, 6));
            } catch (ParseException e){
                return Optional.of(new Error("personalID", "Formatting errors"));
            }
            return Optional.empty();
        }
    }

    private Optional<Error> validateBalance(Double balance){
        if (balance == null || "".equals(balance)) {
            return Optional.of(new Error("balance", "Must be not empty"));
        } else if (String.valueOf(balance).matches(".*\\d.*")){
            return Optional.empty();
        } else{
            return Optional.of(new Error("lastName", "Should not contain numbers"));

        }
    }


}
