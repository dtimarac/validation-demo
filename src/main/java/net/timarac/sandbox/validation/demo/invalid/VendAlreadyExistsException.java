package net.timarac.sandbox.validation.demo.invalid;

public class VendAlreadyExistsException extends RuntimeException {

    public VendAlreadyExistsException() {
    }

    public VendAlreadyExistsException(String message) {
        super(message);
    }

    public VendAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public VendAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public VendAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
