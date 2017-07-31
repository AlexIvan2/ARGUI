package database;

import domain.Subscriber;

import java.util.List;
import java.util.Optional;

public interface SubscriberDAO {

    Subscriber save(Subscriber product);

    Optional<Subscriber> getByAccountNo(Long id);

    Optional<Subscriber> getByFirstName(String firstName);

    void delete(Subscriber subscriber);

    List<Subscriber> getAll();
}
