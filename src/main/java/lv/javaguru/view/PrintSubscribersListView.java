package lv.javaguru.view;


import lv.javaguru.businesslogic.BusinessLogic;
import lv.javaguru.domain.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PrintSubscribersListView implements View {

    private BusinessLogic businessLogic;
    @Autowired
    public PrintSubscribersListView(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Print subscribers list to console execution start!");
        for (Subscriber subscriber : businessLogic.getAllSubscribers()) {
            System.out.println(subscriber.getAccountNo() + " | " + subscriber.getFirstName() + " | " + subscriber.getLastName() + " | " + subscriber.getPersonalID() + " | " + subscriber.getBalance());
        }
        System.out.println("Print shopping list to console execution end!");
        System.out.println();
    }
}
