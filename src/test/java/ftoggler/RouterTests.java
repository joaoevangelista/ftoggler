package ftoggler;

import ftoggler.core.Condition;
import ftoggler.core.Feature;
import ftoggler.core.InMemoryToggleableFeatureRepository;
import ftoggler.env.EnvironmentConditionContext;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static ftoggler.env.EnvironmentConditionContext.ENV_PREFIX;
import static org.junit.Assert.assertTrue;

/**
 * @author Joao Pedro Evangelista
 */
public class RouterTests {

    private Router router;

    private InMemoryToggleableFeatureRepository repository;

    @Before
    public void setUp() throws Exception {
        this.repository = new InMemoryToggleableFeatureRepository();
        System.setProperty(ENV_PREFIX, "FOO_USER");
        this.router = new Router(repository, new EnvironmentConditionContext());
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldHaveAutocompleteFeatureByGivenANewFeatureOnLocator() throws Exception {
        Condition fooUser = new Condition("FOO_USER");
        Feature feature = new Feature("autocomplete", fooUser);
        repository.enable(feature);
        boolean hasAutocomplete = router.isFeatureEnabled("autocomplete");
        assertTrue(hasAutocomplete);
    }

    @Test
    public void givenNoConditionsShouldMatchAnyOnContext() throws Exception {
        Feature feature = new Feature("foo");
        repository.enable(feature);
        boolean isFooEnabled = router.isFeatureEnabled("foo");
        assertTrue(isFooEnabled);
    }

    @Test
    public void givenADisabledFeatureShouldNotGetAsEnabled() throws Exception {
        Feature feature = new Feature("foo");
        repository.enable(feature);
        repository.disable("foo");

    }
}