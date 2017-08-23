package lv.javaguru.database;

import lv.javaguru.domain.User;

import java.util.Optional;

public interface UserDAO {

    User save(User user);

    Optional<User> getById(Long id);

    Optional<User> getByLogin(String login);

}
