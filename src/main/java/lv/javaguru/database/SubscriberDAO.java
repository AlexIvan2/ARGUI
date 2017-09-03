package lv.javaguru.database;

import lv.javaguru.domain.Subscriber;

import java.util.List;
import java.util.Optional;

public interface SubscriberDAO {

    Subscriber save(Subscriber subscriber);

    Optional<Subscriber> getByAccountNo(Long id);

    Optional<Subscriber> getByFirstName(String firstName);

    Optional<Subscriber> getByPersonalId(String personalId);

    void delete(Subscriber subscriber);

    void update(Subscriber subscriber);

    List getAll();
}
