package commands;


import businesslogic.BusinessLogic;
import domain.Subscriber;

public class PrintShoppingListCommand implements Command {

    private BusinessLogic businessLogic;

    public PrintShoppingListCommand(BusinessLogic businessLogic) {
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
