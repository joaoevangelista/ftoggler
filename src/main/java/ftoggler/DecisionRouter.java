package ftoggler;

import ftoggler.core.Condition;
import ftoggler.core.ConditionContext;
import ftoggler.core.Feature;
import ftoggler.core.ToggleableFeatureRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * @author Joao Pedro Evangelista
 */
class DecisionRouter {

    private static final Logger LOGGER = LoggerFactory.getLogger(DecisionRouter.class);

    protected final ToggleableFeatureRepository toggleableFeatureRepository;

    protected final ConditionContext conditionContext;

    public DecisionRouter(ToggleableFeatureRepository toggleableFeatureRepository, ConditionContext conditionContext) {
        this.toggleableFeatureRepository = toggleableFeatureRepository;
        this.conditionContext = conditionContext;
    }


    public boolean isFeatureEnabled(String featureName) {
        if (featureName == null || featureName.isEmpty()) {
            return false;
        } else {
            Feature feature = toggleableFeatureRepository.get(featureName);
            boolean conditionsMatches = conditionsMatches(feature);
            return feature != null && feature.isEnabled() && conditionsMatches;
        }
    }


    protected boolean conditionsMatches(Feature feature) {
        if (feature == null) {
            return false;
        }
        List<Condition> conditions = conditionContext.currentConditions();
        LOGGER.info("Current conditions available are {}", conditions);
        List<Condition> featureConditions = feature.getConditions();
        LOGGER.info("Feature conditions to match are {}", featureConditions);
        // context conditions must contains all feature ones, otherwise
        // if conditions is empty the feature conditions can have no one causing trouble
        return conditions.containsAll(featureConditions);
    }
}
