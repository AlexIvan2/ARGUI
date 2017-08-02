package lv.javaguru.businesslogic;

import lv.javaguru.domain.Subscriber;

import java.util.List;

public interface BusinessLogic {

    Response addSubscriber(String firstName, String lastName, String personalID, Double balance);

    boolean removeSubscriberByAccountNo(Long accountNo);

    List<Subscriber> getAllSubscribers();


}
