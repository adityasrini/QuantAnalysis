package configuration;

import org.eclipse.persistence.jaxb.rs.MOXyJsonProvider;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Aditya Srinivasan
 */

@ApplicationPath("/")
public class RestApplication extends Application {
	
	@Override
	public Set<Class<?>> getClasses() {
		Set<Class<?>> set = new HashSet<>(2);
		set.add(MOXyJsonProvider.class);
		set.add(RESTController.class);
		return set;
	}
	
	@Override
	public Set<Object> getSingletons() {
		MOXyJsonProvider moxyJsonProvider = new MOXyJsonProvider();
		moxyJsonProvider.setFormattedOutput(true);
		moxyJsonProvider.setIncludeRoot(true);
		
		Set<Object> set = new HashSet<>(2);
		set.add(moxyJsonProvider);
		return set;
	}
}
