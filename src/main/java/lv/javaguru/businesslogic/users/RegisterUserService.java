package lv.javaguru.businesslogic.users;

import lv.javaguru.businesslogic.api.Response;
import lv.javaguru.businesslogic.api.Error;
import lv.javaguru.database.UserDAO;
import lv.javaguru.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lv.javaguru.domain.UserBuilder.createUser;

public interface RegisterUserService {
    Response register(String login, String password);
}

@Component
class RegisterUserServiceImpl implements RegisterUserService {

    @Autowired
    private RegisterUserValidator registerUserValidator;
    @Autowired
    private UserDAO dao;

    @Override
    @Transactional
    public Response register(String login, String password) {
        List<Error> validationErrors = registerUserValidator.validate(login, password);
        if (!validationErrors.isEmpty()) {
            return Response.createFailResponse(validationErrors);
        }

        User user = createUser()
                .withLogin(login)
                .withPassword(password).build();

        dao.save(user);

        return Response.createSuccessResponse();
    }
}
