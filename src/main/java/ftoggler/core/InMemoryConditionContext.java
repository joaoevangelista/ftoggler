package ftoggler.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Joao Pedro Evangelista
 */
public class InMemoryConditionContext implements ConditionContext, ModifiableContext {

    private static final ConcurrentMap<Integer, Condition> map = new ConcurrentHashMap<>();

    private static final AtomicInteger counter = new AtomicInteger(0);

    @Override
    public List<Condition> currentConditions() {
        Set<Map.Entry<Integer, Condition>> entries = map.entrySet();
        List<Condition> conditions = new ArrayList<>(entries.size());
        for (Map.Entry<Integer, Condition> entry : entries) {
            conditions.add(entry.getValue());
        }
        return conditions;
    }

    @Override
    public void add(Condition condition) {
        if (condition != null) {
            map.put(counter.incrementAndGet(), condition);
        }
    }
}
