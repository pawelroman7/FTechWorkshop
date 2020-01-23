package pawelroman7.ftech_workshop.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguageEntity, String> {

    @Query(value = "SELECT * FROM country_language JOIN country c on country_language.country_code = c.code WHERE is_official = true AND country_code = ?1 ORDER BY percentage DESC LIMIT 1", nativeQuery = true)
    CountryLanguageEntity getOfficialCountryLanguageByCountryCode(String code);


}
