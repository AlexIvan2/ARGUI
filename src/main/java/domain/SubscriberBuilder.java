package domain;


public class SubscriberBuilder {

    private String firstName;
    private String lastName;
    private int accountNo;
    private double balance;

    private SubscriberBuilder(){}

    public static SubscriberBuilder createProduct(){
        return new SubscriberBuilder();
    }

    public static Subscriber createProduct(String title,
                                        String desctiption){
        return createProduct()
                .withTitle("Milk")
                .withDescription("L1").build();

    }

    public Subscriber build(){
        Subscriber subscriber = new Subscriber();
        subscriber.setFirstName(firstName);
        subscriber.setLastName(lastName);
        return subscriber;
    }

    public SubscriberBuilder withTitle(String title){
        this.firstName = title;
        return this;
    }

    public SubscriberBuilder withDescription(String description) {
        this.lastName = description;
        return this;
    }

}
