package pawelroman7.ftech_workshop.country;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.stereotype.Service;
import pawelroman7.ftech_workshop.configuration.DbConnectionException;

import javax.transaction.Transactional;

@Service
@Transactional
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final HikariDataSource dataSource;

    public CountryServiceImpl(CountryRepository countryRepository, HikariDataSource dataSource) {
        this.countryRepository = countryRepository;
        this.dataSource = dataSource;
    }

    @Override
    public CountryEntity getCountryByCode(String code) {
        if (dataSource.isClosed()){
            throw new DbConnectionException();
        } else {
            return countryRepository.findByCode(code).orElseThrow(CountryNotFoundException::new);
        }
    }
}

