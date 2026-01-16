package sparta.firstevent.exception;

public class NoRightToChangeRoleException extends RuntimeException {
    public NoRightToChangeRoleException() {
    }

    public NoRightToChangeRoleException(String message) {
        super(message);
    }
}
