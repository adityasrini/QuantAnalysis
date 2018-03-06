import java.net.URISyntaxException;
import java.util.List;

import data.Equity;
import data.config.DatabaseAccess;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class DatabaseReadTests
{

	@Test
	void getJpaAccessToLocalDatabase()
			throws URISyntaxException
	{
		assertNotNull(DatabaseAccess.createEntityManager(), "The connection must exist and be accessible");
	}

	@Test
	void getListOfEquities()
			throws URISyntaxException
	{
		List<Equity> list = DatabaseAccess.getListOfEquities();
		assertTrue(list.size() > 1);
	}


}
