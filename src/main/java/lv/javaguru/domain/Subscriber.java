package lv.javaguru.domain;



import javax.persistence.*;

@Entity
@Table(name="products")
public class Subscriber {

    @Id
    @Column(name="account_no")
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long accountNo;

    @Column(name="first_name", nullable = false)
    private String firstName;

    @Column(name="last_name", nullable = false)
    private String lastName;

    @Column(name="personal_id", nullable = false)
    private String personalID;

    @Column(name = "balance", nullable = false)
    private Double balance;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Long getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(Long accountNo) {
        this.accountNo = accountNo;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getPersonalID() {
        return personalID;
    }

    public void setPersonalID(String personalID) {
        this.personalID = personalID;
    }

    @Override
    public String toString() {
        return "Subscriber{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", personalID='" + personalID + '\'' +
                ", accountNo='" + accountNo + '\'' +
                ", balance='" + balance + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subscriber subscriber = (Subscriber) o;

        return accountNo == subscriber.accountNo;
    }
//
//    @Override
//    public int hashCode() {
//        int result = firstName != null ? firstName.hashCode() : 0;
//        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
//        return result;
//    }
}
