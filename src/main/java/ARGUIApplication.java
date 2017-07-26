
import businesslogic.AddSubscriberValidator;
import businesslogic.BusinessLogic;
import businesslogic.BusinessLogicImpl;
import businesslogic.Response;
import view.AddSubscriberView;
import view.View;
import view.PrintShoppingListView;
import view.RemoveProductView;
import database.Database;
import database.DatabaseImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ARGUIApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add subscriber to DB
        // 2. Remove subscriber from DB
        // 3. Print all subscribers to console
        // 4. Exit
        Database database = new DatabaseImpl();
        AddSubscriberValidator addSubscriberValidator = new AddSubscriberValidator(database);
        BusinessLogic businessLogic = new BusinessLogicImpl(database, addSubscriberValidator);

        Map<Integer, View> commands = new HashMap<>();
        commands.put(1, new AddSubscriberView(businessLogic));
        commands.put(2, new RemoveProductView(businessLogic));
        commands.put(3, new PrintShoppingListView(businessLogic));

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 4) {
                break;
            } else {
                View view = commands.get(menuItem);
                view.execute();
            }
        }

    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add product to list");
        System.out.println("2. Remove product from list");
        System.out.println("3. Print list to console");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

}
