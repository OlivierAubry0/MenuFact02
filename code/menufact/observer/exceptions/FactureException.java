package menufact.observer.exceptions;

public class FactureException extends Exception{

    public FactureException(String message){
        super("FactureException: " + message);
   }
}
