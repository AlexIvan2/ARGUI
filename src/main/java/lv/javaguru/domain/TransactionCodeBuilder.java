package lv.javaguru.domain;

public class TransactionCodeBuilder {

    private String transCode;
    private String codeDesc;
    private String updateBalanceYN;

    private TransactionCodeBuilder() {
    }

    public static TransactionCodeBuilder createTransactionCode(){
        return new TransactionCodeBuilder();
    }

    public static TransactionCode createTransactionCode (String transCode, String codeDesc, String updateBalanceYN) {

        return createTransactionCode()
                .withTransCode(transCode)
                .withCodeDesc(codeDesc)
                .withUpdateBalanceYN(updateBalanceYN).build();

    }

    public TransactionCode build(){
        TransactionCode transactionCode = new TransactionCode();
        transactionCode.setTransCode(transCode);
        transactionCode.setCodeDesc(codeDesc);
        transactionCode.setUpdateBalanceYN(updateBalanceYN);

        return transactionCode;
    }

    public TransactionCodeBuilder withTransCode(String transCode){
        this.transCode = transCode;
        return this;
    }

    public TransactionCodeBuilder withCodeDesc(String codeDesc){
        this.codeDesc = codeDesc;
        return this;
    }

    public TransactionCodeBuilder withUpdateBalanceYN(String updateBalanceYN) {
        this.updateBalanceYN = updateBalanceYN;
        return this;
    }
}
