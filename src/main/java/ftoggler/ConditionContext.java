package ftoggler;

import java.util.List;

/**
 * @author Joao Pedro Evangelista
 */
public interface ConditionContext {

    /**
     * Get the current conditions setted on the context be it the environment or a file, or your own implementation
     * @return conditions on the context
     */
    List<Condition> currentConditions();

}
