package lv.javaguru.businesslogic;

import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

public interface RemoveSubscriberByAccountNoService {

    boolean removeSubscriberByAccountNo(Long accountNo);
}

@Component
class RemoveSubscriberByAccountNoServiceImpl implements RemoveSubscriberByAccountNoService {

    @Autowired
    private SubscriberDAO dao;

    @Override
    public boolean removeSubscriberByAccountNo(Long accountNo) {
        Optional<Subscriber> foundProduct = dao.getByAccountNo(accountNo);
        if (foundProduct.isPresent()) {
            Subscriber subscriber = foundProduct.get();
            dao.delete(subscriber);
            return true;
        } else {
            return false;
        }
    }
}