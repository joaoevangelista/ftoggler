package ftoggler.json;

import ftoggler.core.Condition;
import ftoggler.core.Feature;
import org.hamcrest.Matchers;
import org.junit.Test;

import static java.util.Arrays.asList;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * @author Joao Pedro Evangelista
 */
public class FeatureJsonTests {

    @Test
    public void shouldConvertIntoFeature() throws Exception {
        FeatureJson json = new FeatureJson();
        json.setConditions(asList(new Condition("FOO"), new Condition("BAR")));
        json.setEnabled(true);
        json.setName("autocomplete");
        Feature feature = json.toFeature();
        assertThat(feature.getName(), Matchers.is(equalTo(json.getName())));
        assertThat(feature.getConditions(), Matchers.is(equalTo(json.getConditions())));
        assertThat(feature.isEnabled(), Matchers.is(equalTo(json.isEnabled())));
    }
}