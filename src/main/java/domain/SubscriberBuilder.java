package domain;


public class SubscriberBuilder {

    private String firstName;
    private String lastName;
    private String personalID;
    private int accountNo;
    private double balance;

    private SubscriberBuilder(){}

    public static SubscriberBuilder createSubscriber(){
        return new SubscriberBuilder();
    }

    public static Subscriber createSubscriber(String firstName, String lastName,
                                              String personalID, Double balance){
        return createSubscriber()
                .withFirstName("Alex")
                .withLastName("Ivanov")
                .withPersonalID("290890-11602")
                .withBalance(100.0).build();

    }

    public Subscriber build(){
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(firstName);
        subscriber.setLastName(lastName);
        subscriber.setPersonalID(personalID);
        subscriber.setBalance(balance);
        return subscriber;
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
