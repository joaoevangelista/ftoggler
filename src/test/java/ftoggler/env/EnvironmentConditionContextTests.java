package ftoggler.env;

import ftoggler.core.Condition;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

/**
 * @author Joao Pedro Evangelista
 */
public class EnvironmentConditionContextTests {

    private EnvironmentConditionContext context;

    @Before
    public void setUp() throws Exception {
        System.setProperty(EnvironmentConditionContext.ENV_PREFIX, "ALPHA_TESTERS,PREMIUM_USERS");
        System.setProperty("RANDOMPROP", "FOOBAR");
        this.context = new EnvironmentConditionContext();
    }

    @Test
    public void shouldContainsAllValuesFromSystemProperties() throws Exception {
        List<Condition> conditions = context.currentConditions();
        assertThat(conditions, contains(new Condition("ALPHA_TESTERS"), new Condition("PREMIUM_USERS")));
    }
}