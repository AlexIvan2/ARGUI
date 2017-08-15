package lv.javaguru.businesslogic;
import lv.javaguru.businesslogic.api.Error;

import lv.javaguru.database.SubscriberDAO;
import lv.javaguru.domain.Subscriber;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;
import java.util.Optional;

import static lv.javaguru.domain.SubscriberBuilder.createSubscriber;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class AddSubscriberValidatorImplTest {

    @Mock
    private SubscriberDAO subscriberDAO;

    @InjectMocks
    private AddSubscriberValidator validator = new AddSubscriberValidatorImpl();


    @Test
    public void shouldReturnErrorWhenFirstNameIsNull() {
        List<Error> errors = validator.validate(null, "Ivanov", "290890-11602", 0.0);
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0).getField(), is("firstName"));
        assertThat(errors.get(0).getErrorMessage(), is("Must be not empty"));
    }

    @Test
    public void shouldReturnErrorWhenFirstNameIsEmpty() {
        List<Error> errors = validator.validate("", "Ivanov", "290890-11602", 0.0);
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0).getField(), is("firstName"));
        assertThat(errors.get(0).getErrorMessage(), is("Must be not empty"));
    }

    @Test
    public void shouldReturnErrorWhenLastNameIsNull() {
        List<Error> errors = validator.validate("Alex", null, "290890-11602", 0.0);
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0).getField(), is("lastName"));
        assertThat(errors.get(0).getErrorMessage(), is("Must be not empty"));
    }

    @Test
    public void shouldReturnErrorWhenLastNameIsEmpty() {
        List<Error> errors = validator.validate("Alex", "", "290890-11602", 0.0);
        assertThat(errors.size(), is(1));
        assertThat(errors.get(0).getField(), is("lastName"));
        assertThat(errors.get(0).getErrorMessage(), is("Must be not empty"));
    }

//    @Test
//    public void shouldFailIfSubscriberWithSamePersonalIdAlreadyExistInDB() {
//        Subscriber subscriber = createSubscriber().build();
//        doReturn(Optional.of(subscriber)).when(subscriberDAO).getByPersonalId("290890-11602");
//        List<Error> errors = validator.validate("Alex", "Ivanov", "290890-11602", 0.0);
//        assertThat(errors.size(), is(1));
//        assertThat(errors.get(0).getField(), is("personalID"));
//        assertThat(errors.get(0).getErrorMessage(), is("Already exist"));
//    }

}
