
import businesslogic.BusinessLogic;
import businesslogic.BusinessLogicImpl;
import commands.AddSubscriberCommand;
import commands.Command;
import commands.PrintShoppingListCommand;
import commands.RemoveProductCommand;
import database.Database;
import database.DatabaseImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ShoppingListApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1. Add subscriber to DB
        // 2. Remove subscriber from DB
        // 3. Print all subscribers to console
        // 4. Exit
        Database database = new DatabaseImpl();
        BusinessLogic businessLogic = new BusinessLogicImpl(database);

        Map<Integer, Command> commands = new HashMap<>();
        commands.put(1, new AddSubscriberCommand(businessLogic));
        commands.put(2, new RemoveProductCommand(businessLogic));
        commands.put(3, new PrintShoppingListCommand(businessLogic));

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 4) {
                break;
            } else {
                Command command = commands.get(menuItem);
                command.execute();
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
