package lv.javaguru.domain;

import java.util.Date;

public class TransactionBuilder {

    private Subscriber subscriber;
    private Long primaryUid;
    private Long accountNo;
    private String transactionCode;
    private String salesTaxCode;
    private Double amountBeforeTax;
    private Double salesTaxAmount;
    private Double transactionAmount;
    private Date transactionDate;
    private Date transactionEffectiveDate;
    private String billingYN;

    public TransactionBuilder() {
    }

    public static TransactionBuilder createTransaction(){
        return new TransactionBuilder();
    }

    public static Transaction createTransaction(String transactionCode, String salesTaxCode, Double amountBeforeTax,
                                                Double salesTaxAmount, Double transactionAmount, Date transactionDate,
                                                Date transactionEffectiveDate, String billingYN){
        return createTransaction()
                .withTransactionCode(transactionCode)
                .withSalesTaxCode(salesTaxCode)
                .withAmountBeforeTax(amountBeforeTax)
                .withSalesTaxAmount(salesTaxAmount)
                .withTransactionAmount(transactionAmount)
                .withTransactionDate(transactionDate)
                .withTransactionEffectiveDate(transactionEffectiveDate)
                .withBillingYN(billingYN).build();
    }

    public Transaction build(){
        Transaction transaction = new Transaction();
        transaction.setPrimaryUid(primaryUid);
        transaction.setSubscriber(subscriber);
        transaction.setSalesTaxCode(salesTaxCode);
        transaction.setAmountBeforeTax(amountBeforeTax);
        transaction.setTransactionAmount(transactionAmount);
        transaction.setTransactionDate(transactionDate);
        transaction.setTransactionEffectiveDate(transactionEffectiveDate);
        transaction.setBillingYN(billingYN);
        return transaction;
    }

    public TransactionBuilder withSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
        return this;
    }

    public TransactionBuilder withUser(SubscriberBuilder subscriberBuilder) {
        this.subscriber = subscriberBuilder.build();
        return this;
    }

    public TransactionBuilder withTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
        return this;
    }

    public TransactionBuilder withSalesTaxCode(String salesTaxCode) {
        this.salesTaxCode = salesTaxCode;
        return this;
    }

    public TransactionBuilder withAmountBeforeTax(Double amountBeforeTax) {
        this.amountBeforeTax = amountBeforeTax;
        return this;
    }

    public TransactionBuilder withSalesTaxAmount(Double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
        return this;
    }

    public TransactionBuilder withTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
        return this;
    }

    public TransactionBuilder withTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    public TransactionBuilder withTransactionEffectiveDate(Date transactionEffectiveDate) {
        this.transactionEffectiveDate = transactionEffectiveDate;
        return this;
    }

    public TransactionBuilder withBillingYN(String billingYN) {
        this.billingYN = billingYN;
        return this;
    }




}
