package ftoggler;

import org.junit.Before;
import org.junit.Test;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/**
 * @author Joao Pedro Evangelista
 */
public class InMemoryToggleableFeatureRepositoryTests {

    private InMemoryToggleableFeatureRepository repository;

    @Before
    public void setUp() throws Exception {
        repository = new InMemoryToggleableFeatureRepository();
        repository.enable(new Feature("foo", singletonList(new Condition("NOOP")), true));
    }

    @Test
    public void shouldGetAFeatureBasedOnName() throws Exception {
        Feature feature = this.repository.get("foo");
        assertThat(feature.getConditions(), contains(new Condition("NOOP")));
        assertThat(feature.getName(), is("foo"));
    }

    @Test
    public void shouldEnableAFeatureOrCreateEnablingIt() throws Exception {
        repository.enable(new Feature("newStuff", new Condition("GREAT_USERS")));
        Feature newStuff = repository.get("newStuff");
        assertThat(newStuff.isEnabled(), is(true));
        assertThat(newStuff.getConditions(), contains(new Condition("GREAT_USERS")));
        assertThat(newStuff.getName(), is("newStuff"));
    }

    @Test
    public void shouldDisableAFeature() throws Exception {
        repository.disable("foo");
        Feature fooFeature = repository.get("foo");
        assertThat(fooFeature.isEnabled(), is(false));
    }
}