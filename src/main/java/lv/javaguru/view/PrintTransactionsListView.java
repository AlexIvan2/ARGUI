package lv.javaguru.view;

import lv.javaguru.businesslogic.GetTransactionService;
import lv.javaguru.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintTransactionsListView implements View{

    @Autowired
    private GetTransactionService service;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Print subscribers list to console execution start!");
        for (Transaction transaction : service.getAllTransactions()) {
            System.out.println(transaction.toString());
        }
        System.out.println("Print shopping list to console execution end!");
        System.out.println();
    }

}
