package lv.javaguru.controller;


import lv.javaguru.businesslogic.AddTransactionService;
import lv.javaguru.businesslogic.GetTransactionService;
import lv.javaguru.domain.Subscriber;
import lv.javaguru.domain.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class TransactionController {

    @Autowired
    GetTransactionService getTransactionService;

    @Autowired
    AddTransactionService addTransactionService;


    //-------------------Retrieve All Transactions--------------------------------------------------------

    @RequestMapping(value = "/transactions/", method = RequestMethod.GET)
    public ResponseEntity<List<Transaction>> listAllTransactions() {
        List<Transaction> transactions = getTransactionService.getAllTransactions();
        if(transactions.isEmpty()){
            return new ResponseEntity<List<Transaction>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Transaction>>(transactions, HttpStatus.OK);
    }



    //-------------------Retrieve Single Transactions--------------------------------------------------------

    @RequestMapping(value = "/transactions/{primaryUid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Transaction> getTransaction(@PathVariable("primaryUid") long primaryUid) {
        Transaction transactions = getTransactionService.getTransactionByPersonalID(primaryUid).get();
        if (transactions == null) {
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Transaction>(transactions, HttpStatus.OK);
    }

    //------------------- Update a Transactions --------------------------------------------------------

    @RequestMapping(value = "/transactions/update", method = RequestMethod.PUT)
    public ResponseEntity<Transaction> updateTransaction(@RequestBody Transaction transactions) {
        Transaction currentTransaction = getTransactionService.getTransactionByPersonalID(transactions.getPrimaryUid()).get();
        if (currentTransaction == null) {
            return new ResponseEntity<Transaction>(HttpStatus.NOT_FOUND);
        }

        currentTransaction.setAmountBeforeTax(transactions.getAmountBeforeTax());
        currentTransaction.setSalesTaxAmount(transactions.getSalesTaxAmount());
        currentTransaction.setTransactionAmount(transactions.getTransactionAmount());

        addTransactionService.updateTransaction(currentTransaction);
        return new ResponseEntity<Transaction>(currentTransaction, HttpStatus.OK);
    }
}
