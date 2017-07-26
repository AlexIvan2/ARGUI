package view;

import businesslogic.BusinessLogic;

import java.util.Scanner;

public class AddSubscriberView implements View {

    private BusinessLogic businessLogic;

    public AddSubscriberView(BusinessLogic businessLogic){
        this.businessLogic = businessLogic;
    }

    @Override
    public void execute(){
        System.out.println();
        System.out.println("Add subscriber to list execution start!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter subscriber first name:");
        String firstName = sc.nextLine();
        System.out.print("Enter subscriber last name:");
        String lastName = sc.nextLine();
        System.out.print("Enter subscriber personalID:");
        String personalID = sc.nextLine();
        System.out.print("Enter subscriber initial balance:");
        String balance = sc.nextLine();

        ///////////////////////BL/////////////////////
        boolean result = businessLogic.addSubscriber(firstName, lastName,  personalID, Double.parseDouble(balance));

        //////////////BL END//////////
        if (!result) {
            System.out.println("Can not add Subscriber with such account number " +
                    "Already exist in the DB");
        }

        System.out.println("Add subscriber to DB execution end!");
        System.out.println();
    }
}
