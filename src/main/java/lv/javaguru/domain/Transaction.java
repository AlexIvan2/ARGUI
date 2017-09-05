package lv.javaguru.domain;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="transactions")
public class Transaction {
//account_no, prime_uid, trans_code, sales_tax_code, amount_before_tax, sales_tax_amount, trans_amount, trans_dt, trans_effect_dt, billing_yn


    @Id
    @Column(name="prime_uid")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long primaryUid;

    @ManyToOne
    @JoinColumn(name = "account_no", nullable = false)
    private Subscriber subscriber;

    @Column(name="trans_code", nullable = false)
    private String transactionCode;

    @Column(name="sales_tax_code", nullable = false)
    private String salesTaxCode;

    @Column(name="amount_before_tax", nullable = false)
    private Double amountBeforeTax;

    @Column(name="sales_tax_amount", nullable = false)
    private Double salesTaxAmount;

    @Column(name="trans_amount", nullable = false)
    private Double transactionAmount;

    @Column(name="trans_dt", nullable = false)
    private Date transactionDate;

    @Column(name="trans_effect_dt", nullable = false)
    private Date transactionEffectiveDate;

    @Column(name="billing_yn", nullable = false)
    private String billingYN;

    public void setSubscriber(Subscriber subscriber) {
        this.subscriber = subscriber;
    }

    public Long getPrimaryUid() {
        return primaryUid;
    }

    public void setPrimaryUid(Long primaryUid) {
        this.primaryUid = primaryUid;
    }

    public String getTransactionCode() {
        return transactionCode;
    }

    public void setTransactionCode(String transactionCode) {
        this.transactionCode = transactionCode;
    }

    public String getSalesTaxCode() {
        return salesTaxCode;
    }

    public void setSalesTaxCode(String salesTaxCode) {
        this.salesTaxCode = salesTaxCode;
    }

    public Double getAmountBeforeTax() {
        return amountBeforeTax;
    }

    public void setAmountBeforeTax(Double amountBeforeTax) {
        this.amountBeforeTax = amountBeforeTax;
    }

    public Double getSalesTaxAmount() {
        return salesTaxAmount;
    }

    public void setSalesTaxAmount(Double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public Double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(Double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(Date transactionDate) {
        this.transactionDate = transactionDate;
    }

    public Date getTransactionEffectiveDate() {
        return transactionEffectiveDate;
    }

    public void setTransactionEffectiveDate(Date transactionEffectiveDate) {
        this.transactionEffectiveDate = transactionEffectiveDate;
    }

    public String getBillingYN() {
        return billingYN;
    }

    public void setBillingYN(String billingYN) {
        this.billingYN = billingYN;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "primaryUid='" + primaryUid + '\'' +
                ", accountNo='" + subscriber.getAccountNo() + '\'' +
                ", transactionCode='" + transactionCode + '\'' +
                ", salesTaxCode='" + salesTaxCode + '\'' +
                ", amountBeforeTax='" + amountBeforeTax + '\'' +
                ", salesTaxAmount='" + salesTaxAmount + '\'' +
                ", transactionAmount='" + transactionAmount + '\'' +
                ", transactionDate='" + transactionDate + '\'' +
                ", transactionEffectiveDate='" + transactionEffectiveDate + '\'' +
                ", billingYN='" + billingYN + '\'' +
                '}';
    }
}
