package businesslogic;

import domain.Subscriber;

import java.util.List;

public interface BusinessLogic {

    Response addSubscriber(String firstName, String lastName, String personalID, Double balance);

    boolean removeSubscriberByAccountNo(int accountNo);

    List<Subscriber> getAllSubscribers();


}
