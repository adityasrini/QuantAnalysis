import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabasePopulationTests
{

	private static final String QUANDL_URL = "https://www.quandl.com/api/v3/datatables/WIKI/PRICES/delta.json?api_key=ti3mu3cvdKt_47321csp";

	@Test
	void testApiForDataAccess()
	{
		Response response = ClientBuilder.newClient()
										 .target(QUANDL_URL)
										 .request(MediaType.APPLICATION_JSON_TYPE)
										 .get();
		assertTrue(response.getStatus() == 200);
	}
}
