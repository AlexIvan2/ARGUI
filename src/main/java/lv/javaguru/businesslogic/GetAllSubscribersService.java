package lv.javaguru.businesslogic;

import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

public interface GetAllSubscribersService {

    List<Subscriber> getAllSubscribers();

}
@Component
class GetAllSubscribersServiceImpl implements GetAllSubscribersService {

    @Autowired private SubscriberDAO dao;

    @Override
    public List<Subscriber> getAllSubscribers() {
        return dao.getAll();
    }
}

