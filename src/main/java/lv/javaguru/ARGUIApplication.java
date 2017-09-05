package lv.javaguru;

import lv.javaguru.config.SpringAppConfig;
import lv.javaguru.view.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ARGUIApplication {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringAppConfig.class);

        Map<Integer, View> commands = new HashMap<>();
        commands.put(1, applicationContext.getBean(AddSubscriberView.class));
        commands.put(2, applicationContext.getBean(PrintSubscribersListView.class));
        commands.put(3, applicationContext.getBean(RemoveSubscriberView.class));
        commands.put(4, applicationContext.getBean(PrintTransactionsListView.class));

        while (true) {
            printProgramMenu();
            int menuItem = getFromUserMenuItemToExecute();
            if (menuItem == 5) {
                break;
            } else {
                View view = commands.get(menuItem);
                view.execute();
            }
        }

    }

    private static void printProgramMenu() {
        System.out.println("Program Menu:");
        System.out.println("1. Add subscriber");
        System.out.println("2. Print all subscribers");
        System.out.println("3. Remove subscriber");
        System.out.println("4. Show transactions");
        System.out.println("5. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.print("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

}
