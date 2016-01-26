package ftoggler.env;

import ftoggler.core.Condition;
import ftoggler.core.ConditionContext;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;

/**
 * @author Joao Pedro Evangelista
 */
public class EnvironmentConditionContext implements ConditionContext {

    public static final String ENV_PREFIX = "TOGGLE_CONDITIONS";

    @Override
    public List<Condition> currentConditions() {
        Enumeration<?> propertyNames = System.getProperties().propertyNames();
        List<String> names = toList(propertyNames);
        for (String name : names) {
            if (ENV_PREFIX.equals(name)) {
                String property = System.getProperty(name);
                String[] values = property.split(",");
                return valuesToConditions(values);
            }
        }
        return Collections.emptyList();
    }


    private List<Condition> valuesToConditions(String... values) {
        List<Condition> conditions = new ArrayList<>(values.length);
        for (String value : values) {
            conditions.add(new Condition(value));
        }
        return conditions;
    }

    private List<String> toList(Enumeration<?> propertyNames) {
        List<String> names = new ArrayList<>();
        while (propertyNames.hasMoreElements()) {
            String element = propertyNames.nextElement().toString();
            names.add(element);
        }
        return names;
    }
}
