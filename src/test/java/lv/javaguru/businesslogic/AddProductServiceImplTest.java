package lv.javaguru.businesslogic;


import com.google.common.collect.Lists;
import lv.javaguru.businesslogic.api.Response;
import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import lv.javaguru.businesslogic.api.Error;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class AddProductServiceImplTest {

    @Mock
    private SubscriberDAO dao;
    @Mock
    private AddSubscriberValidator addSubscriberValidator;

    @InjectMocks
    private AddSubscriberService service = new AddSubscriberServiceImpl();

    //Where this test is using BusinessLogicImpl alreadyExist method?
    @Test
    public void shouldAddNewSubscriberIfNotExistInTheDB(){
        doReturn(Lists.newArrayList()).when(addSubscriberValidator).validate("Alex", "Ivanov", "290890-11602", 0.0);
        Response result = service.addSubscriber("Alex", "Ivanov", "290890-11602", 0.0);
        assertThat(result.isSuccess(), is(true));
        verify(dao).save(any(Subscriber.class));
    }

    @Test
    public void shouldNotAddNewProductIfAlreadyExistInTheList(){
        Error error = new Error("subscriber", "already exists");
        doReturn(Lists.newArrayList(error)).when(addSubscriberValidator).validate("Alex", "Ivanov", "290890-11602", 0.0);
        Response result = service.addSubscriber("Alex", "Ivanov", "290890-11602", 0.0);
        assertThat(result.isFail(), is(true));
    }
}
