package ftoggler;

import ftoggler.core.*;
import org.junit.Before;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Joao Pedro Evangelista
 */
public class RouterIntegrationTests {

    private DecisionRouter featureContext;

    @Before
    public void setUp() throws Exception {
        InMemoryConditionContext conditionContext = new InMemoryConditionContext();
        InMemoryToggleableFeatureRepository featureLocator = new InMemoryToggleableFeatureRepository();
        createContext(conditionContext);
        createFeatures(featureLocator);
        this.featureContext = new DecisionRouter(featureLocator, conditionContext);
    }

    @Test
    public void shouldAssertTheFeatureValue() throws Exception {
        boolean isAutocompleteEnabled = featureContext.isFeatureEnabled("autocomplete");
        assertFalse("Should fail since it is not declared on the context all conditions", isAutocompleteEnabled);
        boolean isDeleteFileEnabled = featureContext.isFeatureEnabled("delete-file");
        assertTrue("Admin users must have delete feature", isDeleteFileEnabled);
    }

    private void createFeatures(ToggleableFeatureRepository locator) {
        locator.enable(new Feature("autocomplete",
                asList(new Condition("ALPHA_TESTER"), new Condition("BETA_TESTER")), true));
        locator.enable(new Feature("delete-file", new Condition("ROLE_ADMIN")));
    }

    private void createContext(ModifiableContext context) {
        context.add(new Condition("ALPHA_TESTER"));
        context.add(new Condition("ROLE_ADMIN"));
    }
}
