package ftoggler.json;

import ftoggler.core.Condition;
import ftoggler.core.Feature;

import java.util.List;

/**
 * @author Joao Pedro Evangelista
 */
public class FeatureJson {

    private String name;

    private List<Condition> conditions;

    private boolean enabled;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Condition> getConditions() {
        return conditions;
    }

    public void setConditions(List<Condition> conditions) {
        this.conditions = conditions;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public Feature toFeature() {
        return new Feature(this.name, this.conditions, this.enabled);
    }
}
