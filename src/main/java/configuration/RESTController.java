package configuration;

import data.Equity;
import data.config.DatabaseAccess;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * @author Aditya Srinivasan
 */
@Path("/")
public class RESTController {
	
	@GET
	@Path("/hello")
	@Produces(MediaType.TEXT_PLAIN)
	public String helloWorld() {
		return "<h1>Hello World!</h1>";
	}
	
	@Path("/equities")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Equity> listOfEquities(){
		List<Equity> equityList = DatabaseAccess.createEntityManager().createQuery("from Equity", Equity.class).getResultList();
		return equityList;
	}
	
	@Path("/equities/{equity}")
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Equity getEquity(@PathParam("equity") String equity_ticker){
		return DatabaseAccess.createEntityManager()
												.createQuery("from Equity where ticker=:ticker", Equity.class)
												.setParameter("ticker",equity_ticker)
												.getSingleResult();
	}
}