package lv.javaguru.database;

import lv.javaguru.domain.Transaction;

import java.util.List;
import java.util.Optional;

public interface TransactionDAO {

    Transaction save(Transaction transaction);

    Optional<Transaction> getByPrimaryUid(Long primaryUid);

    Optional<Transaction> getByAccountNo(Long accountNo);

    List getAll();

    void delete(Transaction transaction);

    void update(Transaction transaction);

}
