package test.task.exceptions;

public class BadArgumentsException extends RuntimeException {
    public BadArgumentsException(String message) {
        super(message);
    }

    public BadArgumentsException(String message, Throwable cause) {
        super(message, cause);
    }
}
