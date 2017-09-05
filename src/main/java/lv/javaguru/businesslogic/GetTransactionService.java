package lv.javaguru.businesslogic;

import lv.javaguru.database.TransactionDAO;
import lv.javaguru.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

public interface GetTransactionService {

    Optional<Transaction> getTransactionByAccountNo(Long accountNo);

    Optional<Transaction> getTransactionByPersonalID(Long primaryUid);

    List<Transaction> getAllTransactions();
}

@Component
class GetTransactionServiceImpl implements GetTransactionService {

    @Autowired
    private TransactionDAO dao;

    @Override
    @Transactional
    public Optional<Transaction> getTransactionByAccountNo(Long accountNo) {
        return dao.getByAccountNo(accountNo);
    }

    @Override
    @Transactional
    public Optional<Transaction> getTransactionByPersonalID(Long primaryUid) {
        return dao.getByPrimaryUid(primaryUid);
    }

    @Override
    @Transactional
    public List<Transaction> getAllTransactions() {
        return dao.getAll();
    }
}
