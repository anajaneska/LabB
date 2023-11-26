package mk.ukim.finki.labb.model.exceptions;

public class NonValidIdException extends RuntimeException{
    public NonValidIdException() {
        super("Invalid ID Exception");
    }
}
