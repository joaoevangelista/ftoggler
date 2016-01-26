package ftoggler.env;

import ftoggler.core.DelegatingFeatureRepository;
import ftoggler.core.Feature;

/**
 * @author Joao Pedro Evangelista
 */
public class EnvironmentAwareFeatureRepository extends DelegatingFeatureRepository {

    public EnvironmentAwareFeatureRepository() {
        super();
    }

    @Override
    public void loadPropertiesAndSetOnContext() {
        String property = System.getProperties().getProperty(ENV_KEY);
        if (property != null) {
            String[] values = property.split(",");
            for (String value : values) {
                this.enable(new Feature(value.trim()));
            }
        }
    }

}
