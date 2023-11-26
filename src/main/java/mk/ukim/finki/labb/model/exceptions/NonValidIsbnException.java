package mk.ukim.finki.labb.model.exceptions;

public class NonValidIsbnException extends RuntimeException{
    public NonValidIsbnException() {
        super("Invalid ISBN exception");
    }
}
