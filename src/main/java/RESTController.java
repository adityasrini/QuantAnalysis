import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 * @author Aditya Srinivasan on 2/24/18.
 */

@Path("/hello")
public class RESTController {
	
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "<h1>Hello World!</h1>";
	}
	
}