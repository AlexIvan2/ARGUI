package lv.javaguru.database.orm;

import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public class SubscriberDAOImpl implements SubscriberDAO {

    @Autowired private SessionFactory sessionFactory;

    @Override
    public Subscriber save(Subscriber subscriber) {
        session().save(subscriber);
        return subscriber;
    }

    @Override
    public Optional<Subscriber> getByAccountNo(Long account_no){
        Subscriber subscriber = (Subscriber) session().createCriteria(Subscriber.class)
                .add(Restrictions.eq("accountNo", account_no))
                .uniqueResult();
        return Optional.ofNullable(subscriber);
    }

    @Override
    public Optional<Subscriber> getByFirstName(String first_name){
        Subscriber subscriber = (Subscriber) session().createCriteria(Subscriber.class)
                .add(Restrictions.eq("firstName", first_name))
                .uniqueResult();
        return Optional.ofNullable(subscriber);
    }

    @Override
    public Optional<Subscriber> getByPersonalId(String personal_id){
        Subscriber subscriber = (Subscriber) session().createCriteria(Subscriber.class)
                .add(Restrictions.eq("personal_id", personal_id))
                .uniqueResult();
        return Optional.ofNullable(subscriber);
    }

    @Override
    public void delete(Subscriber subscriber) {
        session().delete(subscriber);
    }

    @Override
    public void update(Subscriber subscriber) {
        session().update(subscriber);
    }

    @Override
    public List<Subscriber> getAll() {
        return session()
                .createCriteria(Subscriber.class)
                .list();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }


}
