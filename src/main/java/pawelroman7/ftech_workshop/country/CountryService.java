package pawelroman7.ftech_workshop.country;

import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public interface CountryService {

    CountryEntity getCountryByCode(String code);


}
