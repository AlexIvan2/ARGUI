package lv.javaguru.database;

import lv.javaguru.config.SpringAppConfig;
import lv.javaguru.domain.Subscriber;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;


import java.util.Optional;

import static lv.javaguru.domain.SubscriberBuilder.createSubscriber;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringAppConfig.class)
@Transactional
public class ProductDAOImplTest {

    @Autowired private DatabaseUtil databaseUtil;
    @Autowired private SubscriberDAO subscriberDAO;

    @Before
    public void init() {
        databaseUtil.cleanDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        Subscriber subscriber = create("Alex1", "Ivan1", "298090-11601", 101.0);
        assertThat(subscriber.getAccountNo(), is(notNullValue()));

        Optional<Subscriber> subscriberFromDB = subscriberDAO.getByAccountNo(subscriber.getAccountNo());

        assertThat(subscriberFromDB.isPresent(), is(true));
        assertEquals(subscriber.getAccountNo(), subscriberFromDB.get().getAccountNo());
        assertEquals(subscriber.getFirstName(), subscriberFromDB.get().getFirstName());
        assertEquals(subscriber.getLastName(), subscriberFromDB.get().getLastName());
        assertEquals(subscriber.getPersonalID(), subscriberFromDB.get().getPersonalID());
        assertEquals(subscriber.getBalance(), subscriberFromDB.get().getBalance());
    }

    @Test
    public void testGetByFirstName() {
        Subscriber subscriber = create("Alex2", "Ivan2", "298090-11602", 102.0);

        Optional<Subscriber> subscriberFromDB = subscriberDAO.getByFirstName(subscriber.getFirstName());

        assertThat(subscriberFromDB.isPresent(), is(true));
        assertEquals(subscriber.getAccountNo(), subscriberFromDB.get().getAccountNo());
        assertEquals(subscriber.getFirstName(), subscriberFromDB.get().getFirstName());
        assertEquals(subscriber.getLastName(), subscriberFromDB.get().getLastName());
        assertEquals(subscriber.getPersonalID(), subscriberFromDB.get().getPersonalID());
        assertEquals(subscriber.getBalance(), subscriberFromDB.get().getBalance());
    }


    private Subscriber create(String firstName, String lastName, String personalID, Double balance) {
        Subscriber subscriber = createSubscriber()
                .withFirstName(firstName)
                .withLastName(lastName)
                .withPersonalID(personalID)
                .withBalance(balance).build();
        return subscriberDAO.save(subscriber);
    }
}
