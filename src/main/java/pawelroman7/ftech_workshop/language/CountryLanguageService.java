package pawelroman7.ftech_workshop.language;

import org.springframework.stereotype.Service;

@Service
public interface CountryLanguageService {
    String getOfficialCountryLangByCountryCode(String code);
}
