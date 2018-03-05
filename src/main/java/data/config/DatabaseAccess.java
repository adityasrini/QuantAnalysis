package data.config;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseAccess
{

	
	public static Connection getJdbcConnection()
			throws URISyntaxException, SQLException
	{

		URI databaseUri = new URI(System.getenv("HEROKU_POSTGRESQL_WHITE_URL"));

		String username = databaseUri.getUserInfo()
									 .split(":")[0];
		String password = databaseUri.getUserInfo()
									 .split(":")[1];
		String databaseUrl =
				"jdbc:postgresql://" + databaseUri.getHost() + ":" + databaseUri.getPort() + databaseUri.getPath();
		return DriverManager.getConnection(databaseUrl, username, password);
	}

	public static EntityManager createEntityManager()
	{
		
		return Persistence.createEntityManagerFactory("securities_master")
						  .createEntityManager();
	}
}
