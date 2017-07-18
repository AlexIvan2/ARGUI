package businesslogic;


import database.Database;
import domain.Subscriber;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class BusinessLogicImplTest {

    private Database dao;
    private BusinessLogic service;

    @Before
    public void init(){
        dao = mock(Database.class);
        service = new BusinessLogicImpl(dao);
    }
    //Where this test is using BusinessLogicImpl alreadyExist method?
    @Test
    public void shouldAddNewSubscriberIfNotExistInTheDB(){
        doReturn(Optional.empty()).when(dao).getSubscriberByPersonalID("290890-11602");
        boolean result = service.addSubscriber("Alex", "Ivanov", "290890-11602", 0);
        assertThat(result, is(true));
        verify(dao).getSubscriberByPersonalID("290890-11602");
    }

//    @Test
//    public void shouldNotAddNewProductIfAlreadyExistInTheList(){
//        Subscriber subscriber = mock(Subscriber.class);
//        doReturn(Optional.of(subscriber)).when(dao).getSubscriberByAccountNo("Milk");
//        boolean result = service.addSubscriber("Milk", "1L");
//        assertThat(result, is(false));
//    }
}
