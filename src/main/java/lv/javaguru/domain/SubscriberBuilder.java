package lv.javaguru.domain;


public class SubscriberBuilder {

    private String firstName;
    private String lastName;
    private String personalID;
    private Long accountNo;
    private Double balance;

    private SubscriberBuilder(){}

    public static SubscriberBuilder createSubscriber(){
        return new SubscriberBuilder();
    }

    public static Subscriber createSubscriber(String firstName, String lastName,
                                              String personalID, Double balance){
        return createSubscriber()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withPersonalID(personalID)
                .withBalance(balance).build();

    }

    public Subscriber build(){
        Subscriber subscriber = new Subscriber();
        subscriber.setAccountNo(accountNo);
        subscriber.setFirstName(firstName);
        subscriber.setLastName(lastName);
        subscriber.setPersonalID(personalID);
        subscriber.setBalance(balance);
        return subscriber;
    }

    public SubscriberBuilder withAccountNo(Long accountNo){
        this.accountNo = accountNo;
        return this;
    }

    public SubscriberBuilder withFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }

    public SubscriberBuilder withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public SubscriberBuilder withPersonalID(String personalID){
        this.personalID = personalID;
        return this;
    }

    public SubscriberBuilder withBalance(Double balance) {
        this.balance = balance;
        return this;
    }

}
