package ftoggler;

import ftoggler.core.InMemoryConditionContextTests;
import ftoggler.env.EnvironmentConditionContextTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Joao Pedro Evangelista
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({EnvironmentConditionContextTests.class,
        InMemoryConditionContextTests.class, RouterTests.class, RouterIntegrationTests.class,
})
public class AllTests {

}
