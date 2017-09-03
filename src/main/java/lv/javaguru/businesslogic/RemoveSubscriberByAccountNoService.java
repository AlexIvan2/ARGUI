package lv.javaguru.businesslogic;

import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.Optional;

public interface RemoveSubscriberByAccountNoService {

    boolean removeSubscriberByAccountNo(Long accountNo);
}

@Component
class RemoveSubscriberByAccountNoServiceImpl implements RemoveSubscriberByAccountNoService {

    @Autowired
    private SubscriberDAO dao;

    @Override
    @Transactional
    public boolean removeSubscriberByAccountNo(Long accountNo) {
        Optional<Subscriber> foundSubscriber = dao.getByAccountNo(accountNo);
        if (foundSubscriber.isPresent()) {
            Subscriber subscriber = foundSubscriber.get();
            dao.delete(subscriber);
            return true;
        } else {
            return false;
        }
    }
}