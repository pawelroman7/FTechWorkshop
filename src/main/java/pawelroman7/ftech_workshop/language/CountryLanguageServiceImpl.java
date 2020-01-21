package pawelroman7.ftech_workshop.language;

public class CountryLanguageServiceImpl implements CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    public CountryLanguageServiceImpl(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    @Override
    public String getOfficialCountryLangByCountryCode(String code) {
        return countryLanguageRepository.getOfficialCountryLanguageByCountryCode(code);
    }
}
