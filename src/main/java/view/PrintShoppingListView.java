package view;


import businesslogic.BusinessLogic;
import domain.Subscriber;

public class PrintShoppingListView implements View {

    private BusinessLogic businessLogic;

    public PrintShoppingListView(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Print shopping list to console execution start!");
        for (Subscriber subscriber : businessLogic.getAllSubscribers()) {
            System.out.println(subscriber.getFirstName() + "[" + subscriber.getLastName() + "]");
        }
        System.out.println("Print shopping list to console execution end!");
        System.out.println();
    }
}
