package lv.javaguru.view;

import lv.javaguru.businesslogic.RemoveSubscriberByAccountNoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class RemoveSubscriberView implements View {

    @Autowired private RemoveSubscriberByAccountNoService service;

    @Override
    public void execute() {
        System.out.println();
        System.out.println("Remove subscribers from DB!");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter account number:");
        final String accountNo = sc.nextLine();

        ///////////////////BL/////////////////////////

        boolean result = service.removeSubscriberByAccountNo(Long.parseLong(accountNo));

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
