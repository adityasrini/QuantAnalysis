package data.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Properties;

import data.Equity;

public class DatabaseAccess
{

	//Generates the parameters from an environmental variable
	private static String[] urlParametersGenerator()
			throws URISyntaxException
	{
		String[] databaseUrlParameters = new String[3];
		URI databaseUri = new URI(System.getenv("HEROKU_POSTGRESQL_WHITE_URL"));

		//URI
		databaseUrlParameters[0] =
				"jdbc:postgresql://" + databaseUri.getHost() + ":" + databaseUri.getPort() + databaseUri.getPath();

		//Username
		databaseUrlParameters[1] = databaseUri.getUserInfo()
											  .split(":")[0];
		//Password
		databaseUrlParameters[2] = databaseUri.getUserInfo()
											  .split(":")[1];
		return databaseUrlParameters;
	}

	public static EntityManager createEntityManager()
			throws URISyntaxException
	{

		//Loads the Postgres Driver so Tomcat doesn't whine
		try
		{
			Class.forName("org.postgresql.Driver");
		}
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		}

		String[] databaseUrlParameters = urlParametersGenerator();
		Properties properties = new Properties();
		properties.setProperty("javax.persistence.jdbc.url", databaseUrlParameters[0]);
		properties.setProperty("javax.persistence.jdbc.user", databaseUrlParameters[1]);
		properties.setProperty("javax.persistence.jdbc.password", databaseUrlParameters[2]);

		return Persistence.createEntityManagerFactory("securities_master", properties)
						  .createEntityManager();

	}

	public static List<Equity> getListOfEquities()
			throws URISyntaxException
	{
		EntityManager entityManager = createEntityManager();

		List<Equity> equityList = entityManager
										  .createQuery("from Equity", Equity.class)
										  .getResultList();
		entityManager.close();
		return equityList;
	}

	public static Equity getSingleEquity(String equity_ticker)
			throws URISyntaxException
	{
		EntityManager entityManager = createEntityManager();
		Equity equity = entityManager
								.createQuery("from Equity where ticker=:ticker", Equity.class)
								.setParameter("ticker", equity_ticker)
								.getSingleResult();
		entityManager.close();
		return equity;
	}
}
