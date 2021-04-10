package exception;

public class ConnectionException extends Exception{
    @Override
    public String getMessage() {
            return "Erreur connexion";
        }
}

