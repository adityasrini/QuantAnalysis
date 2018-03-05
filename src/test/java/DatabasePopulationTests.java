import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatabasePopulationTests
{

	@Test
	void testApiForDataAccess()
	{
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("https://www.quandl.com/api/v3/datatables/WIKI/PRICES/delta.json?api_key=ti3mu3cvdKt_47321csp");
		Invocation.Builder invocationBuilder = target.request(MediaType.APPLICATION_JSON_TYPE);
		Response response = invocationBuilder.get();
		System.out.println(response.readEntity(String.class));
		assertNotNull(response);
	}
}
