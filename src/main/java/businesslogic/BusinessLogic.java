package businesslogic;

import domain.Subscriber;

import java.util.List;

public interface BusinessLogic {

    boolean addSubscriber(String firstName, String lastName, String personalID, double balance);

    boolean removeSubscriberByAccountNo(int accountNo);

    List<Subscriber> getAllSubscribers();


}
