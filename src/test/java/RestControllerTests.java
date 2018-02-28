import configuration.RESTController;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.core.Application;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Created by Aditya Srinivasan
 */
public class RestControllerTests extends JerseyTest {
	
	@Override
	protected Application configure() {
		return new ResourceConfig(RESTController.class);
	}
	
	@Test
	public void testForHelloWorld() {
		String result = target("hello").request()
									   .get(String.class);
		String expected = "<h1>Hello World!</h1>";
		assertEquals(expected, result, "Should say Hello World!");
	}
	
	@Test
	public void testEquitiesRestEndpointForVisibility() {
		List result = target("equities").request().get(List.class);
		System.out.println(result);
//		assertTrue(result.contains("list of equities"),"there should be a list of equities");
	}
}
