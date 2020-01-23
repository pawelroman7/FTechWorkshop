package pawelroman7.ftech_workshop.country;

import com.zaxxer.hikari.HikariDataSource;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import pawelroman7.ftech_workshop.configuration.DbConnectionException;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

class CountryServiceImplTest {
    private final CountryRepository countryRepository;
    private final HikariDataSource dataSource;

    CountryServiceImplTest(CountryRepository countryRepository, HikariDataSource dataSource) {
        this.countryRepository = countryRepository;
        this.dataSource = dataSource;
    }
    @Rule
    ExpectedException expectedException = ExpectedException.none();

    @Test(expected = DbConnectionException.class)
    void givenNoDbConnection_whenRequestsFromRepo_throwsException() {
        dataSource.close();
        countryRepository.findByCode("BHR").orElseThrow(CountryNotFoundException::new);
        expectedException.expect(DbConnectionException.class);
        expectedException.expectMessage(containsString("INTERNAL_ERROR"));
    }
}