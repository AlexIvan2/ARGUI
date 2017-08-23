package lv.javaguru.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="transaction_codes")
public class TransactionCode extends BaseEntity {

    @Id
    @Column(name="trans_code")
    private String transCode;

    @Column(name="code_desc")
    private String codeDesc;

    @Column(name="update_balance_yn")
    private String updateBalanceYN;

    public String getTransCode() {
        return transCode;
    }

    public void setTransCode(String transCode) {
        this.transCode = transCode;
    }

    public String getCodeDesc() {
        return codeDesc;
    }

    public void setCodeDesc(String codeDesc) {
        this.codeDesc = codeDesc;
    }

    public String getUpdateBalanceYN() {
        return updateBalanceYN;
    }

    public void setUpdateBalanceYN(String updateBalanceYN) {
        this.updateBalanceYN = updateBalanceYN;
    }
}
