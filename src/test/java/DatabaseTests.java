import data.config.DatabaseAccess;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DatabaseTests {
	
	@Test
	void getJdbcAccessToTheLocalDatabase() throws Exception {
		assertNotNull(DatabaseAccess.getJdbcConnection(), "The connection must exist and be accessible.");
	}
	
	@Test
	void getJpaAccessToLocalDatabase(){
		assertNotNull(DatabaseAccess.createEntityManager(), "The connection must exist and be accessible");
	}
	
}
