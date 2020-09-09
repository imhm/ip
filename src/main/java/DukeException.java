public class DukeException extends Exception{

    private String exception;

    public DukeException(String message) {
        super(message);
        exception = message;
    }

    public String getException() {
        return exception;
    }
}
