package lv.javaguru.controller;


import lv.javaguru.businesslogic.AddSubscriberService;
import lv.javaguru.businesslogic.GetSubscriberService;
import lv.javaguru.businesslogic.RemoveSubscriberByAccountNoService;
import lv.javaguru.domain.Subscriber;
import lv.javaguru.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;


@RestController
public class SubscriberController {

    @Autowired
    GetSubscriberService getSubscriberService;

    @Autowired
    AddSubscriberService addSubscriberService;

    @Autowired
    RemoveSubscriberByAccountNoService removeSubscriberByAccountNoService;


    //-------------------Retrieve All Subscribers--------------------------------------------------------

    @RequestMapping(value = "/subscribers/", method = RequestMethod.GET)
    public ResponseEntity<List<Subscriber>> listAllUsers() {
        List<Subscriber> subscribers = getSubscriberService.getAllSubscribers();
        if(subscribers.isEmpty()){
            return new ResponseEntity<List<Subscriber>>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Subscriber>>(subscribers, HttpStatus.OK);
    }



    //-------------------Retrieve Single Subscriber--------------------------------------------------------

    @RequestMapping(value = "/subscribers/{accountNo}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Subscriber> getSubscriber(@PathVariable("accountNo") long accountNo) {
        System.out.println("Fetching Subscriber with account number " + accountNo);
        Subscriber subscriber = getSubscriberService.getSubscriberByAccountNo(accountNo).get();
        if (subscriber == null) {
            System.out.println("Subscriber with account no " + accountNo + " not found");
            return new ResponseEntity<Subscriber>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Subscriber>(subscriber, HttpStatus.OK);
    }



    //-------------------Create a Subscriber--------------------------------------------------------

    @RequestMapping(value = "/subscribers/", method = RequestMethod.POST)
    public ResponseEntity<Void> createSubscriber(@RequestBody Subscriber subscriber, UriComponentsBuilder ucBuilder) {
        System.out.println("Creating Subscriber " + subscriber);

        addSubscriberService.addSubscriber(subscriber.getFirstName(), subscriber.getLastName(), subscriber.getPersonalID(), subscriber.getBalance());

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/subscribers/{accountNo}").buildAndExpand(subscriber.getAccountNo()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }


    //------------------- Update a Subscriber --------------------------------------------------------

    @RequestMapping(value = "/subscribers/update", method = RequestMethod.PUT)
    public ResponseEntity<Subscriber> updateUser(@RequestBody Subscriber subscriber) {
        System.out.println("Updating Subscriber " + subscriber.getAccountNo());

        Subscriber currentSubscriber = getSubscriberService.getSubscriberByAccountNo(subscriber.getAccountNo()).get();

        if (currentSubscriber == null) {
            System.out.println("Subscriber with account number " + subscriber.getAccountNo() + " not found");
            return new ResponseEntity<Subscriber>(HttpStatus.NOT_FOUND);
        }

        currentSubscriber.setFirstName(subscriber.getFirstName());
        currentSubscriber.setLastName(subscriber.getLastName());
        currentSubscriber.setPersonalID(subscriber.getPersonalID());
        currentSubscriber.setBalance(subscriber.getBalance());

        addSubscriberService.updateSubscriber(currentSubscriber);
        return new ResponseEntity<Subscriber>(currentSubscriber, HttpStatus.OK);
    }



    //------------------- Delete a Subscriber --------------------------------------------------------

    @RequestMapping(value = "/subscribers/delete", method = RequestMethod.POST)
    public ResponseEntity<Void> deleteSubscriber(@RequestBody Long accountNo) {
        System.out.println("Fetching & Deleting Subscriber with account number " + accountNo);

        Subscriber currentSubscriber = getSubscriberService.getSubscriberByAccountNo(accountNo).get();

        if (currentSubscriber == null) {
            System.out.println("Subscriber with account number " + accountNo + " not found");
            return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
        }

        removeSubscriberByAccountNoService.removeSubscriberByAccountNo(accountNo);
        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }

}
