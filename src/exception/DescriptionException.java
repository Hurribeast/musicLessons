package exception;

public class DescriptionException extends Exception{
    private String description;
    public DescriptionException(String description) {
        this.description = description;
    }
}
