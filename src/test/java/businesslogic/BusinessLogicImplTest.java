package businesslogic;


import database.Database;
import org.junit.Before;
import org.junit.Test;
import domain.Subscriber;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BusinessLogicImplTest {

    private Database database;
    private BusinessLogic service;
    private AddSubscriberValidator addSubscriberValidator;

    @Before
    public void init(){
        database = mock(Database.class);
        addSubscriberValidator = mock(AddSubscriberValidator.class);
        service = new BusinessLogicImpl(database, addSubscriberValidator);
    }
    //Where this test is using BusinessLogicImpl alreadyExist method?
    @Test
    public void shouldAddNewSubscriberIfNotExistInTheDB(){
        doReturn(Optional.empty()).when(database).getSubscriberByPersonalID("290890-11602");
        Response result = service.addSubscriber("Alex", "Ivanov", "290890-11602", 0.0);
        assertThat(result.isSuccess(), is(true));
        verify(database).addSubscriber(any(Subscriber.class));
    }

//    @Test
//    public void shouldNotAddNewProductIfAlreadyExistInTheList(){
//        Subscriber subscriber = mock(Subscriber.class);
//        doReturn(Optional.of(subscriber)).when(database).getSubscriberByAccountNo("Milk");
//        boolean result = service.addSubscriber("Milk", "1L");
//        assertThat(result, is(false));
//    }
}
