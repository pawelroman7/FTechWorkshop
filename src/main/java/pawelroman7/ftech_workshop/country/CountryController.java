package pawelroman7.ftech_workshop.country;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import pawelroman7.ftech_workshop.language.CountryLanguageService;

@Controller
public class CountryController {
    private final CountryService countryService;
    private final CountryLanguageService countryLanguageService;
    private final ModelMapper modelMapper;

    public CountryController(CountryService countryService, CountryLanguageService countryLanguageService, ModelMapper modelMapper) {
        this.countryService = countryService;
        this.countryLanguageService = countryLanguageService;
        this.modelMapper = modelMapper;
    }


    @GetMapping("/{code}")
    public String getCountry(@PathVariable (name = "code") String code, Model model){
        CountryDTO countryDTO = modelMapper.map(countryService.getCountryByCode(code), CountryDTO.class);
        model.addAttribute("countryDTO", countryDTO);
        model.addAttribute("countryLanguage", countryLanguageService.getOfficialCountryLangByCountryCode(code));
        return "";
        //TODO: Controller and view, add Jackson lib
    }

    @PostMapping("/")
    public String postCountry(){

        return "";
    }
}
