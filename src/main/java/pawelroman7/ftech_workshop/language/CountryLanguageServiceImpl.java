package pawelroman7.ftech_workshop.language;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CountryLanguageServiceImpl implements CountryLanguageService {

    private final CountryLanguageRepository countryLanguageRepository;

    public CountryLanguageServiceImpl(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    @Override
    public CountryLanguageEntity getCountryLanguagesByCountryCode(String code) {
        return countryLanguageRepository.getOfficialCountryLanguageByCountryCode(code);
    }
}
