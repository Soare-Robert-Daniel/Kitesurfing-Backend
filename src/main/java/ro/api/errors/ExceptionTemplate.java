package ro.api.errors;

public class ExceptionTemplate extends Exception {
    public ExceptionTemplate() {
    }

    public ExceptionTemplate(String message) {
        super(message);
    }
}
