import javax.ws.rs.core.Application;
import javax.ws.rs.core.GenericType;
import java.util.List;

import configuration.RESTController;
import data.Equity;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Aditya Srinivasan
 * <p>
 * There are issues with JUnit 5 and Jersey. @BeforeAll and @AfterAll annotations are so
 * Junit 5 behaves properly with Jersey Test. This is related to Issue #3662
 * https://github.com/jersey/jersey/issues/3662
 * <p>
 * `@TestInstance(TestInstance.Lifecycle.PER_CLASS)` is added for that same reason.
 * <p>
 * There will still be exceptions thrown pertaining to the JUnit Vintage tests such as:
 * `java.lang.Exception: No tests found matching Method testToGetOneEquity(RestControllerTests) from org.junit.vintage.engine.descriptor`
 * <p>
 * It is safe to ignore them.
 */

// Setup so Junit 5 behaves properly with Jersey Test.
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class RestControllerTests
		extends JerseyTest
{

	// Setup so Junit 5 behaves properly with Jersey Test.
	@BeforeAll
	public void before()
			throws Exception
	{
		super.setUp();
	}

	// Setup so Junit 5 behaves properly with Jersey Test.
	@AfterAll
	public void after()
			throws Exception
	{
		super.tearDown();
	}

	@Override
	protected Application configure()
	{
		return new ResourceConfig(RESTController.class);
	}

	@Test
	public void testForHelloWorld()
	{
		String result = target("hello").request()
									   .get(String.class);
		String expected = "<h1>Hello World!</h1>";
		assertEquals(expected, result, "Should say Hello World!");
	}

	@Test
	public void testEquitiesRestEndpointForVisibility()
	{
		List result = target("equities").request()
										.get(new GenericType<List<Equity>>()
										{
										});
		assertTrue(result.size() > 0, "there should be at least one equity");
	}

	@ParameterizedTest
	@ValueSource(strings = { "AAPL",
							 "GOOG" })
	public void testToGetOneEquity(String equity_ticker)
	{
		Equity equity = target("equities/{equity}")
								.resolveTemplate("equity", equity_ticker)
								.request()
								.get(Equity.class);
		System.out.println(equity.getTicker());
	}
}
