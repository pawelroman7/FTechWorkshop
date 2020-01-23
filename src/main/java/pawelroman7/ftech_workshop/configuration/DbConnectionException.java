package pawelroman7.ftech_workshop.configuration;

public class DbConnectionException extends RuntimeException {
    public DbConnectionException(){
        super("INTERNAL_ERROR");
    }
}
