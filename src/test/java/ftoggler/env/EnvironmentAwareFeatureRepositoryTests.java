package ftoggler.env;

import org.junit.Before;

/**
 * @author Joao Pedro Evangelista
 */
public class EnvironmentAwareFeatureRepositoryTests {

    private EnvironmentAwareFeatureRepository repository;

    @Before
    public void setUp() throws Exception {
        System.setProperty(EnvironmentAwareFeatureRepository.ENV_KEY, "FOO,BAR, ROO,GOO");
        this.repository = new EnvironmentAwareFeatureRepository();
    }

}