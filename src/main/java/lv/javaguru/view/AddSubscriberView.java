package lv.javaguru.view;

import lv.javaguru.businesslogic.AddSubscriberService;
import lv.javaguru.businesslogic.api.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;
@Component
public class AddSubscriberView implements View {

    @Autowired private AddSubscriberService addSubscriberService;

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
        Response response = addSubscriberService.addSubscriber(firstName, lastName, personalID, Double.parseDouble(balance));

        //////////////BL END//////////
        if (response.isFail()) {
            System.out.println("Can not add Subscriber with such account number " +
                    "Already exist in the DB");
        }

        System.out.println("Add subscriber to DB execution end!");
        System.out.println();
    }
}
