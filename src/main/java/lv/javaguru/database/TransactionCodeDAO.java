package lv.javaguru.database;

import lv.javaguru.domain.TransactionCode;

import java.util.List;
import java.util.Optional;

public interface TransactionCodeDAO {

    TransactionCode save(TransactionCode transactionCode);

    Optional<TransactionCode> getByTransCode(String transCode);

    Optional<TransactionCode> getByCodeDesc(String codeDesc);

    Optional<TransactionCode> getByBalanceUpdateYN(String balanceUpdateYN);

    void delete (TransactionCode transactionCode);

    List getAll();

}
