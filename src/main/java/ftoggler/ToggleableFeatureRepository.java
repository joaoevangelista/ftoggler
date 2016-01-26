package ftoggler;

/**
 * Part of the searching context to find where is stored the current developed features
 * You can implement your own custom implementations to search on MongoDB, File, or where you would like to store them
 *
 * @author Joao Pedro Evangelista
 */
public interface ToggleableFeatureRepository {

    Feature get(String feature);

    void enable(Feature feature);

    void disable(String feature);
}
