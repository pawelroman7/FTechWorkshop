package pawelroman7.ftech_workshop.country;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pawelroman7.ftech_workshop.language.CountryLanguageService;

@Controller
public class CountryController {
    private final CountryService countryService;
    private final CountryLanguageService countryLanguageService;
    private final ObjectMapper objectMapper;

    public CountryController(CountryService countryService, CountryLanguageService countryLanguageService, ObjectMapper objectMapper) {
        this.countryService = countryService;
        this.countryLanguageService = countryLanguageService;
        this.objectMapper = objectMapper;
    }

    @GetMapping("/{code}")
    @ResponseBody
    public String getCountry(@PathVariable (name = "code") String code) throws JsonProcessingException {
        CountryDTO countryDTO = new CountryDTO(countryService.getCountryByCode(code), countryLanguageService.getCountryLanguagesByCountryCode(code));
        return objectMapper.writeValueAsString(countryDTO);
    }

    @PostMapping("/")
    public String postCountry(){
        return "";
    }
}
