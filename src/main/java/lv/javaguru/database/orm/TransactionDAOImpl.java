package lv.javaguru.database.orm;

import lv.javaguru.database.TransactionDAO;
import lv.javaguru.domain.Transaction;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TransactionDAOImpl implements TransactionDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Transaction save(Transaction transaction) {
        session().save(transaction);
        return transaction;
    }

    @Override
    public Optional<Transaction> getByAccountNo(Long accountNo){
        Transaction transaction = (Transaction) session().createCriteria(Transaction.class)
                .add(Restrictions.eq("accountNo", accountNo))
                .uniqueResult();
        return Optional.ofNullable(transaction);
    }

    @Override
    public Optional<Transaction> getByPrimaryUid(Long primaryUid){
        Transaction transaction = (Transaction) session().createCriteria(Transaction.class)
                .add(Restrictions.eq("primaryUid", primaryUid))
                .uniqueResult();
        return Optional.ofNullable(transaction);
    }

    @Override
    public void delete(Transaction transaction) {
        session().delete(transaction);
    }

    @Override
    public void update(Transaction transaction) {
        session().update(transaction);
    }


    @Override
    public List<Transaction> getAll() {
        return session()
                .createCriteria(Transaction.class)
                .list();
    }

    private Session session() {
        return sessionFactory.getCurrentSession();
    }

}
