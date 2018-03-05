import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import data.Equity;
import data.config.DatabaseAccess;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatabaseTests {
	
	@Test
	void getJdbcAccessToTheLocalDatabase() throws Exception {
		Connection connection = DatabaseAccess.getJdbcConnection();
		ResultSet resultSet = connection.createStatement().executeQuery("SELECT * FROM symbol");
		StringBuilder stringBuilder = new StringBuilder();
		while (resultSet.next()){
			stringBuilder.append(resultSet.getArray(3));
			stringBuilder.append(" ");
		}
		System.out.println(stringBuilder.toString());
		assertNotNull(DatabaseAccess.getJdbcConnection(), "The connection must exist and be accessible.");
	}
	
	@Test
	void getJpaAccessToLocalDatabase(){
		assertNotNull(DatabaseAccess.createEntityManager(), "The connection must exist and be accessible");
	}
	
	@Test
	void getListOfEntities(){
		List list = DatabaseAccess.createEntityManager()
								  .createQuery("from Equity", Equity.class)
								  .getResultList();
		list.forEach(System.out::println);
	}
	
}
