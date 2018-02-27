import configuration.RESTController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import javax.ws.rs.core.Application;

/**
 * Created by Aditya Srinivasan
 */
public class RestControllerTests extends JerseyTest {
	
	@Test
	public void testForHelloWorld() {
		String result = target("hello").request()
									   .get(String.class);
		String expected = "<h1>Hello World!</h1>";
		Assertions.assertEquals(expected, result, "Should say Hello World!");
	}
	
	@Override
	protected Application configure() {
		return new ResourceConfig(RESTController.class);
	}
}
