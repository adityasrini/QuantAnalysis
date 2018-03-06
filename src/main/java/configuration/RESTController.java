package configuration;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URISyntaxException;
import java.util.List;

import data.Equity;
import data.config.DatabaseAccess;

/**
 * @author Aditya Srinivasan
 */
@Path("/")
public class RESTController
{

	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_HTML)
	public String helloWorld()
	{
		return "<h1>Hello World!</h1>";
	}

	@Path("/equities")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Equity> listOfEquities()
			throws URISyntaxException
	{
		return DatabaseAccess.getListOfEquities();
	}

	@Path("/equities/{equity}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Equity getEquity(@PathParam("equity") String equity_ticker)
			throws URISyntaxException
	{
		return DatabaseAccess.getSingleEquity(equity_ticker);
	}
}