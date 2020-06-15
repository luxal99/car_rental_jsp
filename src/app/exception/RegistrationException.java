package app.exception;

public class RegistrationException extends Exception {

    protected String message = "Registraion failed!Try again";

    public RegistrationException() {
    }

    public RegistrationException(String s) {
        super(s);
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
