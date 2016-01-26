package ftoggler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static ftoggler.EnvironmentConditionContext.ENV_PREFIX;

/**
 * @author Joao Pedro Evangelista
 */
public class RouterTests {

    private Router router;

    private InMemoryToggleableFeatureRepository featureLocator;

    @Before
    public void setUp() throws Exception {
        this.featureLocator = new InMemoryToggleableFeatureRepository();
        System.setProperty(ENV_PREFIX, "FOO_USER");
        this.router = new Router(featureLocator, new EnvironmentConditionContext());
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldHaveAutocompleteFeatureByGivenANewFeatureOnLocator() throws Exception {
        Condition fooUser = new Condition("FOO_USER");
        Feature feature = new Feature("autocomplete", fooUser);
        featureLocator.enable(feature);
        boolean hasAutocomplete = router.isFeatureEnabled("autocomplete");
        Assert.assertTrue(hasAutocomplete);
    }
}