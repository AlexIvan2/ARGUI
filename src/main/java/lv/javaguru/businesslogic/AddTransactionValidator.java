package lv.javaguru.businesslogic;

import com.google.common.collect.Lists;
import lv.javaguru.businesslogic.api.Error;
import lv.javaguru.database.TransactionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface AddTransactionValidator {

    List<Error> validate(String transactionCode, String salesTaxCode, Double amountBeforeTax,
                         Double salesTaxAmount, Double transactionAmount, Date transactionDate,
                         Date transactionEffectiveDate, String billingYN);

}
@Component
class AddTransactionValidatorImpl implements AddTransactionValidator {

    @Autowired
    private TransactionDAO transactionDAO;

    private boolean alreadyExist(Long primaryUid) {
        return transactionDAO.getByPrimaryUid(primaryUid).isPresent();
    }

    @Override
    public List<Error> validate(String transactionCode, String salesTaxCode, Double amountBeforeTax,
                                Double salesTaxAmount, Double transactionAmount, Date transactionDate,
                                Date transactionEffectiveDate, String billingYN){
        List<Error> errors = Lists.newArrayList();
        validateTransactionCode(transactionCode).ifPresent(e -> errors.add(e));
        //TODO
//        validateSalesTaxCode(salesTaxCode).ifPresent(e -> errors.add(e));
//        validateAmountBeforeTax(amountBeforeTax).ifPresent(e -> errors.add(e));
//        validateSalesTaxAmount(salesTaxAmount).ifPresent(e -> errors.add(e));
//        validateTransactionAmount(transactionAmount).ifPresent(e -> errors.add(e));
//        validateTransactionDate(transactionDate).ifPresent(e -> errors.add(e));
//        validateTransactionEffectiveDate(transactionEffectiveDate).ifPresent(e -> errors.add(e));
//        validateBillingYN(billingYN).ifPresent(e -> errors.add(e));
        return errors;
    }

    private Optional<Error> validateTransactionCode(String transactionCode){
        if (transactionCode == null || "".equals(transactionCode)) {
            return Optional.of(new Error("transactionCode", "Must be not empty"));
        } else if (transactionCode.matches(".*\\d.*")){
            return Optional.of(new Error("transactionCode", "Should not contain numbers"));
        } else{
            return Optional.empty();
        }
    }
}