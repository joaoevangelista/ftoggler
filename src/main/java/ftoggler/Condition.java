package ftoggler;

/**
 * @author Joao Pedro Evangelista
 */
public class Condition {

    private final String name;

    public Condition(String name) {
        if (name == null){
            throw new IllegalArgumentException("Condition name must be not null!");
        }
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Condition condition = (Condition) o;

        return name.equals(condition.name);

    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    @Override
    public String toString() {
        return "Condition: " + this.name;
    }
}
