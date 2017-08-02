package lv.javaguru;

import lv.javaguru.config.SpringAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import lv.javaguru.view.AddSubscriberView;
import lv.javaguru.view.PrintSubscribersListView;
import lv.javaguru.view.RemoveProductView;
import lv.javaguru.view.View;

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
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Map<Integer, View> commands = new HashMap<>();
        commands.put(1, applicationContext.getBean(AddSubscriberView.class));
        commands.put(2, applicationContext.getBean(PrintSubscribersListView.class));
        commands.put(3, applicationContext.getBean(RemoveProductView.class));

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
