package lv.javaguru.businesslogic;


import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class BusinessLogicImplTest {

    private SubscriberDAO subscriberDAO;
    private BusinessLogic service;
    private AddSubscriberValidator addSubscriberValidator;

    @Before
    public void init(){
        subscriberDAO = mock(SubscriberDAO.class);
        addSubscriberValidator = mock(AddSubscriberValidator.class);
        service = new BusinessLogicImpl(subscriberDAO, addSubscriberValidator);
    }
    //Where this test is using BusinessLogicImpl alreadyExist method?
    @Test
    public void shouldAddNewSubscriberIfNotExistInTheDB(){
        doReturn(Optional.empty()).when(subscriberDAO).getByPersonalId("290890-11602");
        Response result = service.addSubscriber("Alex", "Ivanov", "290890-11602", 0.0);
        assertThat(result.isSuccess(), is(true));
        verify(subscriberDAO).equals(any(Subscriber.class));
    }

//    @Test
//    public void shouldNotAddNewProductIfAlreadyExistInTheList(){
//        Subscriber subscriber = mock(Subscriber.class);
//        doReturn(Optional.of(subscriber)).when(lv.javaguru.database).getSubscriberByAccountNo("Milk");
//        boolean result = service.addSubscriber("Milk", "1L");
//        assertThat(result, is(false));
//    }
}
