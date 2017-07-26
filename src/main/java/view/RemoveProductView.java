package view;

import businesslogic.BusinessLogic;

import java.util.Scanner;

public class RemoveProductView implements View {

    private BusinessLogic businessLogic;

    public RemoveProductView(BusinessLogic businessLogic) {
        this.businessLogic = businessLogic;
    }

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove subscribers from DB!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number:");
        final String accountNo = sc.nextLine();

        ///////////////////BL/////////////////////////

        boolean result = businessLogic.removeSubscriberByAccountNo(Integer.parseInt(accountNo));

        ////////////////////BL end /////////////////

        if (result) {
            System.out.println("Subscriber with account " + accountNo + " was found and will be removed from DB!");
        } else {
            System.out.println("Subscriber with account " + accountNo + " not found and not be removed from DB!");
        }

        System.out.println("Remove customer from DB execution end!");
        System.out.println();
    }
}
