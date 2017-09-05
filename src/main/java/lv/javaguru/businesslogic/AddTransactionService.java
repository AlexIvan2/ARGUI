package lv.javaguru.businesslogic;

import lv.javaguru.businesslogic.api.Error;
import lv.javaguru.businesslogic.api.Response;
import lv.javaguru.database.TransactionDAO;
import lv.javaguru.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.beans.Transient;
import java.util.List;

public interface AddTransactionService {

    Response addTransaction();

    Response updateTransaction(Transaction transaction);

}

@Component
class AddTransactionServiceImpl implements AddTransactionService {

    @Autowired private TransactionDAO dao;
    @Autowired
    private AddTransactionValidator addTransactionValidator;

    @Override
    public Response addTransaction() {
        //TODO
        return Response.createSuccessResponse();
    }

    @Override
    @Transactional
    public Response updateTransaction(Transaction transaction) {
        List<Error> validationErrors = addTransactionValidator.validate(transaction.getTransactionCode(), transaction.getSalesTaxCode(), transaction.getAmountBeforeTax(),
                transaction.getSalesTaxAmount(), transaction.getTransactionAmount(), transaction.getTransactionDate(), transaction.getTransactionEffectiveDate(), transaction.getBillingYN());
        if(!validationErrors.isEmpty()){
            return Response.createFailResponse(validationErrors);
        }

        dao.update(transaction);

        return Response.createSuccessResponse();
    }
}
