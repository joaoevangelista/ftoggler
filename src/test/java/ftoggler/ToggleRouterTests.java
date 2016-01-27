package ftoggler;

import ftoggler.core.Feature;
import ftoggler.core.InMemoryConditionContext;
import ftoggler.core.InMemoryToggleableFeatureRepository;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Joao Pedro Evangelista
 */
public class ToggleRouterTests {

    private ToggleRouter router;


    @Before
    public void setUp() throws Exception {

        router = new ToggleRouter(new InMemoryToggleableFeatureRepository(), new InMemoryConditionContext());
    }

    @Test
    public void testEnable() throws Exception {
        router.enable(new Feature("bar"));
        boolean isBarEnabled = router.isFeatureEnabled("bar");
        assertTrue(isBarEnabled);
    }

    @Test
    public void testDisable() throws Exception {
        router.disable("foo");
        boolean isEnabled = router.isFeatureEnabled("foo");
        assertFalse(isEnabled);
    }
}