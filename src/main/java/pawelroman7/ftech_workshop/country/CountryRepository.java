package pawelroman7.ftech_workshop.country;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, String>  {

        Optional<CountryEntity> findByCode(String code);

}
