package pawelroman7.ftech_workshop.country;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.math.BigDecimal;

class CountryRepositoryTest {
    private final CountryRepository countryRepository;

    CountryRepositoryTest(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }
    @Rule
    ExpectedException expectedException = ExpectedException.none();

    @Test
    void givenCountryCode_whenRequestedFromRepo_returnsCountryEntityOrThrowsException() {
        CountryEntity dummyCountry = new CountryEntity("BHR", "Bahrain", "Asia", "Middle East", 694f, (short) 1974, 617000, 73f, BigDecimal.valueOf(6366.00), BigDecimal.valueOf(6097.00), "Al-Bahrayn", "Monarchy (Emirate)", "Hamad ibn Isa al-Khalifa", "BH");
        CountryEntity countryToTestCorrectCode = countryRepository.findByCode("BHR").orElseThrow(CountryNotFoundException::new);
        CountryEntity countryToTestNotCorrectCode = countryRepository.findByCode("BH").orElseThrow(CountryNotFoundException::new);
        assertThat(dummyCountry, equalTo(countryToTestCorrectCode));
    }
    @Test(expected = CountryNotFoundException.class)
    void givenWrongCountryCode_whenRequestedFromRepo_throwsException() {
        CountryEntity dummyCountry = new CountryEntity("BHR", "Bahrain", "Asia", "Middle East", 694f, (short) 1974, 617000, 73f, BigDecimal.valueOf(6366.00), BigDecimal.valueOf(6097.00), "Al-Bahrayn", "Monarchy (Emirate)", "Hamad ibn Isa al-Khalifa", "BH");
        CountryEntity countryToTestNotCorrectCode = countryRepository.findByCode("BH").orElseThrow(CountryNotFoundException::new);
        expectedException.expect(CountryNotFoundException.class);
        expectedException.expectMessage(containsString("INVALID_COUNTRY_CODE"));
    }
}