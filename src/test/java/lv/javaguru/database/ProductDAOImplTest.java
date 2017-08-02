package lv.javaguru.database;

import lv.javaguru.database.jdbc.SubscriberDAOImpl;
import lv.javaguru.domain.Subscriber;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static lv.javaguru.domain.SubscriberBuilder.createSubscriber;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertEquals;

public class ProductDAOImplTest {

    private DatabaseUtil databaseUtil = new DatabaseUtil();
    private SubscriberDAO subscriberDAO = new SubscriberDAOImpl();

    @Before
    public void init() {
        databaseUtil.cleanDatabase();
    }

    @Test
    public void testCreate() throws Exception {
        Subscriber subscriber = createSubscriber()
                .withFirstName("TestFirstName")
                .withLastName("TestLastName")
                .withPersonalID("290890-11602")
                .withBalance(10.5).build();

        assertThat(subscriber.getAccountNo(), is(nullValue()));
        subscriber = subscriberDAO.save(subscriber);
        assertThat(subscriber.getAccountNo(), is(notNullValue()));

        Optional<Subscriber> subscriberFromDB = subscriberDAO.getByAccountNo(subscriber.getAccountNo());

        assertThat(subscriberFromDB.isPresent(), is(true));
        assertEquals(subscriber.getAccountNo(), subscriberFromDB.get().getAccountNo());
        assertEquals(subscriber.getFirstName(), subscriberFromDB.get().getFirstName());
        assertEquals(subscriber.getLastName(), subscriberFromDB.get().getLastName());
        assertEquals(subscriber.getPersonalID(), subscriberFromDB.get().getPersonalID());
        assertEquals(subscriber.getBalance(), subscriberFromDB.get().getBalance());
    }
}
