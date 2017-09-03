package lv.javaguru.businesslogic;

import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface GetSubscriberService {

    Optional<Subscriber> getSubscriberByAccountNo(Long accountNo);

    Optional<Subscriber> getSubscriberByPersonalID(String personalID);

    List<Subscriber> getAllSubscribers();

}
@Component
class GetSubscriberServiceImpl implements GetSubscriberService {

    @Autowired private SubscriberDAO dao;

    @Override
    @Transactional
    public Optional<Subscriber> getSubscriberByAccountNo(Long accountNo) {
        return dao.getByAccountNo(accountNo);
    }

    @Override
    @Transactional
    public Optional<Subscriber> getSubscriberByPersonalID(String personalID) {
        return dao.getByPersonalId(personalID);
    }

    @Override
    @Transactional
    public List<Subscriber> getAllSubscribers() {
        return dao.getAll();
    }

}

