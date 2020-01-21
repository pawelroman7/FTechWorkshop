package pawelroman7.ftech_workshop.country;

import java.util.function.Supplier;

public class CountryNotFoundException extends RuntimeException {

    public CountryNotFoundException(){
        super("message");
    }
}
