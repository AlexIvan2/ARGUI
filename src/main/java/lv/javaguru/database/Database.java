package lv.javaguru.database;

import lv.javaguru.domain.Subscriber;

import java.util.List;
import java.util.Optional;

public interface Database {

    void addSubscriber(Subscriber subscriber);
    void deleteSubscriber(Subscriber subscriber);
    List<Subscriber> getAllSubscribers();
    Optional<Subscriber> getSubscriberByAccountNo(int accountNo);
    Optional<Subscriber> getSubscriberByPersonalID(String personalID);

}
