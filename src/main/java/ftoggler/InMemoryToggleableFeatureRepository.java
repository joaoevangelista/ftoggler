package ftoggler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author Joao Pedro Evangelista
 */
public class InMemoryToggleableFeatureRepository implements ToggleableFeatureRepository {

    private static final ConcurrentMap<String, Feature> data = new ConcurrentHashMap<>(10);

    private static final Logger LOGGER = LoggerFactory.getLogger(InMemoryToggleableFeatureRepository.class);

    @Override
    public Feature getFeature(String feature) {
        return data.get(feature);
    }

    @Override
    public void enable(Feature feature) {
        data.putIfAbsent(feature.getName(), feature);
        Feature saved = data.get(feature.getName());
        if (saved != null && !saved.isEnabled()) {
            Feature enabledFeature = saved.enable();
            data.replace(saved.getName(), saved, enabledFeature);
        }
    }

    @Override
    public void disable(String feature) {
        Feature saved = data.get(feature);
        if (saved != null) {
            Feature disabledFeature = saved.disable();
            data.replace(saved.getName(), saved, disabledFeature);
        } else {
            LOGGER.warn("Feature {} already disabled or not exits", feature);
        }
    }

}
