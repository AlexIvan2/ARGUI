package businesslogic;


import database.Database;
import domain.Subscriber;

import java.util.List;
import java.util.Optional;

public class BusinessLogicImpl implements BusinessLogic {

    private Database dao;


    public BusinessLogicImpl(Database dao){
        this.dao = dao;
    }

    @Override
    public boolean addSubscriber(String firstName, String lastName, String personalID, double balance) {
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(firstName);
        subscriber.setLastName(lastName);
        subscriber.setPersonalID(personalID);
        subscriber.setBalance(balance);



        if (alreadyExist(subscriber)) {
            return false;
        } else {
            dao.addSubscriber(subscriber);
            return true;
        }
    }

    @Override
    public boolean removeSubscriberByAccountNo(int accountNo) {
        Optional<Subscriber> foundProduct = dao.getSubscriberByAccountNo(accountNo);
        if (foundProduct.isPresent()) {
            Subscriber subscriber = foundProduct.get();
            dao.deleteSubscriber(subscriber);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Subscriber> getAllSubscribers() {
        return dao.getAllSubscribers();
    }

    private boolean alreadyExist(Subscriber subscriber) {
        return dao.getSubscriberByPersonalID(subscriber.getPersonalID()).isPresent();
    }
}
