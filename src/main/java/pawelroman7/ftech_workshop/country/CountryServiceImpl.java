package pawelroman7.ftech_workshop.country;

import com.zaxxer.hikari.HikariDataSource;

import java.sql.SQLException;

public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final HikariDataSource dataSource;

    public CountryServiceImpl(CountryRepository countryRepository, HikariDataSource dataSource) {
        this.countryRepository = countryRepository;
        this.dataSource = dataSource;
    }

    @Override
    public CountryEntity getCountryByCode(String code) {
        try {
            dataSource.getConnection();
        } catch (SQLException e) {
            e = new SQLException("INTERNAL_ERROR");
            e.printStackTrace();
        }
        return countryRepository.findByCountryCode(code)
                .orElseThrow(CountryNotFoundException::new);

    }
}

