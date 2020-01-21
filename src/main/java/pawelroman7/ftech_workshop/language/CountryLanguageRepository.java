package pawelroman7.ftech_workshop.language;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CountryLanguageRepository extends JpaRepository<CountryLanguageEntity, String> {

    @Query("SELECT l.language FROM CountryLanguageEntity l JOIN FETCH CountryEntity c WHERE c.code = ?1 AND l.isOfficial = true")
    String getOfficialCountryLanguageByCountryCode(String code);
}
