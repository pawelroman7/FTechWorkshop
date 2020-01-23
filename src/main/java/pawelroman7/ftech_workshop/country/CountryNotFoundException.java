package pawelroman7.ftech_workshop.country;

class CountryNotFoundException extends RuntimeException {

    CountryNotFoundException(){
        super("INVALID_COUNTRY_CODE");
    }
}
