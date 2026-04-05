package hu.cubix.cloud.api;

import hu.cubix.cloud.model.CubixResponse;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.not;

class ApplicationControllerTest {

    String testDefaultMessage = "This is a default message";

    @Test
    void defaultMessage() {
        String defaultMessage = testDefaultMessage;
        ApplicationController controller = new ApplicationController(defaultMessage);
        CubixResponse response = controller.demoMessage("");
        assertThat(response.time(), is(notNullValue()));
        assertThat(response.message(), is(defaultMessage));
    }

    @Test
    void customMessage() {
        String message = "hello";
        ApplicationController controller = new ApplicationController(testDefaultMessage);
        CubixResponse response = controller.demoMessage(message);
        assertThat(response.time(), is(notNullValue()));
        assertThat(response.message(), is(message));
    }

    @Test
    void anotherTestMessage() {
        String message = "asdf";
        ApplicationController controller = new ApplicationController(testDefaultMessage);
        CubixResponse response = controller.demoMessage(message);
        assertThat(response.time(), is(notNullValue()));
        assertThat(response.message(), is(not(testDefaultMessage)));
        assertThat(response.message(), is(message));
    }
}
