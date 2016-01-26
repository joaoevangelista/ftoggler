package ftoggler.core;

/**
 * @author Joao Pedro Evangelista
 */
public abstract class DelegatingFeatureRepository implements ToggleableFeatureRepository {

    public static final String ENV_KEY = "FEATURES_ENABLED";

    private final InMemoryToggleableFeatureRepository inMemoryRepository;

    protected DelegatingFeatureRepository() {
        this.inMemoryRepository = new InMemoryToggleableFeatureRepository();
        loadPropertiesAndSetOnContext();
    }

    @Override
    public Feature get(String feature) {
        return inMemoryRepository.get(feature);
    }

    @Override
    public void enable(Feature feature) {
        this.inMemoryRepository.enable(feature);
    }

    @Override
    public void disable(String feature) {
        this.inMemoryRepository.disable(feature);
    }


    public abstract void loadPropertiesAndSetOnContext();
}
