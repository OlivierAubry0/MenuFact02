package menufact.factory.exceptions;

public class PlatException extends Exception{
    public PlatException(String message){
        super("PlatException: " + message);
    }
}