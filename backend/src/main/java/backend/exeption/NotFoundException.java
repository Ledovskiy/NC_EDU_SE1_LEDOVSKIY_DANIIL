package backend.exeption;

public class NotFoundException extends NullPointerException {

    private String message;

    public NotFoundException(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}

