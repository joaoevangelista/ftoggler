package ftoggler.core;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Joao Pedro Evangelista
 */
public class InMemoryConditionContextTests {

    private InMemoryConditionContext context;

    @Before
    public void setUp() throws Exception {
        context = new InMemoryConditionContext();
        context.add(new Condition("FOO"));
        context.add(new Condition("BAR"));
        context.add(new Condition("BOR"));
    }

    @Test
    public void givenSomeConditionsShouldGetAllConditionsAvailableOnMemory() throws Exception {
        List<Condition> conditions = context.currentConditions();
        assertThat(conditions.size(), is(3));
        assertThat(conditions, contains(new Condition("FOO"), new Condition("BAR"), new Condition("BOR")));
    }
}