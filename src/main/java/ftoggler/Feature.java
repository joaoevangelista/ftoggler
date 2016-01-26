package ftoggler;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Joao Pedro Evangelista
 */
public class Feature {

    private final String name;

    private final List<Condition> conditions;

    private final boolean enabled;

    public Feature(String name, List<Condition> conditions, boolean enabled) {
        this.name = name;
        this.conditions = conditions;
        this.enabled = enabled;
    }

    public Feature(String name, Condition... conditions) {
        this(name, asList(conditions), false);
    }


    public List<Condition> getConditions() {
        return conditions;
    }

    public String getName() {
        return name;
    }

    public boolean isEnabled() {
        return enabled;
    }
}
