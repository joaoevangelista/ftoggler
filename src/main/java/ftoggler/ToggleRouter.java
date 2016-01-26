package ftoggler;

import ftoggler.core.ConditionContext;
import ftoggler.core.Feature;
import ftoggler.core.ToggleableFeatureRepository;

/**
 * Router specialization that can enable and disable features as well all capabilities from {@link Router Router}
 *
 * @author Joao Pedro Evangelista
 */
public class ToggleRouter extends Router {

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
