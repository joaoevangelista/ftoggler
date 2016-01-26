package ftoggler;

/**
 * @author Joao Pedro Evangelista
 */
public class FTogglerException extends RuntimeException {

    public FTogglerException() {
        super();
    }

    public FTogglerException(String message) {
        super(message);
    }

    public FTogglerException(String message, Throwable cause) {
        super(message, cause);
    }

    public FTogglerException(Throwable cause) {
        super(cause);
    }

}
