package pawelroman7.ftech_workshop.language;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;


class CountryLanguageRepositoryTest {
    private final CountryLanguageRepository countryLanguageRepository;

    CountryLanguageRepositoryTest(CountryLanguageRepository countryLanguageRepository) {
        this.countryLanguageRepository = countryLanguageRepository;
    }

    @Test
    void givenCountryCode_whenRequestedFromRepo_returnsCountryLanguageEntity() {

        CountryLanguageEntity dummyLanguage = new CountryLanguageEntity("Arabic", true, 67.7f);
        CountryLanguageEntity languageToTest = countryLanguageRepository.getOfficialCountryLanguageByCountryCode("BHR");
        assertThat(dummyLanguage, equalToObject(languageToTest));
    }
}