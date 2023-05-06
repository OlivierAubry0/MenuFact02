package menufact.factory.plats.exceptions;

public class PlatException extends Exception{
    public PlatException(String message){
        super("PlatException: " + message);
    }
}