package pawelroman7.ftech_workshop.country;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import pawelroman7.ftech_workshop.language.CountryLanguageEntity;

import java.io.IOException;

@JsonSerialize(using = CountryDTO.CountryDTOSerializer.class)
class CountryDTO {
    private String name;
    private String continent;
    private int population;
    private Float lifeExpectancy;
    private String countryLanguage;

    CountryDTO (CountryEntity countryEntity, CountryLanguageEntity countryLanguageEntity){
        this.name = countryEntity.getName();
        this.continent = countryEntity.getContinent();
        this.population = countryEntity.getPopulation();
        this.lifeExpectancy = countryEntity.getLifeExpectancy();
        this.countryLanguage = countryLanguageEntity.getLanguage();
    }

    private String getName() {
        return name;
    }

    private String getContinent() {
        return continent;
    }

    private int getPopulation() {
        return population;
    }

    private Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    private String getCountryLanguage() {
        return countryLanguage;
    }

    static class CountryDTOSerializer extends StdSerializer<CountryDTO> {

        protected CountryDTOSerializer(){
            super(CountryDTO.class);
        }

        protected CountryDTOSerializer(Class<CountryDTO> t) {
            super(t);
        }

        @Override
        public void serialize(CountryDTO countryDTO, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
            jsonGenerator.writeStartObject();
            jsonGenerator.writeStringField("name", countryDTO.getName());
            jsonGenerator.writeStringField("continent", countryDTO.getContinent());
            jsonGenerator.writeStringField("population", String.valueOf(countryDTO.getPopulation()));
            jsonGenerator.writeStringField("life_expectancy", String.valueOf(countryDTO.getLifeExpectancy()));
            jsonGenerator.writeStringField("country_language", countryDTO.getCountryLanguage());
            jsonGenerator.writeEndObject();

        }
    }
}
