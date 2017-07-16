package database;


import com.google.common.collect.Lists;
import domain.Subscriber;

import java.util.List;
import java.util.Optional;

public class DatabaseImpl implements Database{

    private List<Subscriber> subscribers = Lists.newArrayList();

    @Override
    public void addSubscriber(Subscriber subscriber){
        subscribers.add(subscriber);
    }

    @Override
    public void deleteSubscriber(Subscriber subscriber) {
        subscribers.remove(subscriber);
    }

    @Override
    public List<Subscriber> getAllSubscribers(){
        return Lists.newArrayList(subscribers);
    }

    @Override
    public Optional<Subscriber> getSubscriberByAccountNo(int accountNo){
        return subscribers.stream()
                .filter(p -> p.getAccountNo() == accountNo)
                .findFirst();
    }
}
