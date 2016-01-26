package ftoggler;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Joao Pedro Evangelista
 */
public class InMemoryToggleableFeatureRepository implements ToggleableFeatureRepository {

    private static final ConcurrentMap<String, Feature> data = new ConcurrentHashMap<>(10);

    @Override
    public Feature getFeature(String feature) {
        return data.get(feature);
    }

    @Override
    public void enable(Feature feature) {
        data.putIfAbsent(feature.getName(), feature);
        Feature saved = data.get(feature.getName());
        if (!saved.isEnabled()){
            Feature enabledFeature = new Feature(saved.getName(), saved.getConditions(), true);
            data.replace(saved.getName(), saved, enabledFeature);
        }
    }

    @Override
    public void disable(String feature) {
        Feature saved = data.get(feature);
        Feature disabledFeature = new Feature(saved.getName(), saved.getConditions(), false);
        data.replace(saved.getName(), saved, disabledFeature);
    }

}
