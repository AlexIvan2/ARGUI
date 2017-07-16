package businesslogic;

import domain.Subscriber;

import java.util.List;

public interface BusinessLogic {

    boolean addSubscriber(String firstName, String lastName, double balance);

    boolean removeSubscriberByAccountNo(int accountNo);

    List<Subscriber> getAllSubscribers();


}
