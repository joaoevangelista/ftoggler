package ftoggler;

import ftoggler.core.ConditionContext;
import ftoggler.core.Feature;
import ftoggler.core.ToggleableFeatureRepository;

/**
 * DecisionRouter specialization that can enable and disable features as well all capabilities from {@link DecisionRouter DecisionRouter}
 * Creating a instance and sharing it across the application is the best way to use it.
 * @author Joao Pedro Evangelista
 */
public class ToggleRouter extends DecisionRouter {

    public ToggleRouter(ToggleableFeatureRepository toggleableFeatureRepository, ConditionContext conditionContext) {
        super(toggleableFeatureRepository, conditionContext);
    }

    /**
     * Delegating method that can enable a feature on current repository
     *
     * @param feature the feature to be enabled
     */
    public void enable(Feature feature) {
        toggleableFeatureRepository.enable(feature);
    }

    /**
     * Delegating method that can disable a feature on current repository
     *
     * @param featureName name of the feature to disable
     */
    public void disable(String featureName) {
        toggleableFeatureRepository.disable(featureName);
    }
}
