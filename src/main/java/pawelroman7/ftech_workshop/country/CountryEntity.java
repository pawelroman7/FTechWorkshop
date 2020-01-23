package pawelroman7.ftech_workshop.country;

import pawelroman7.ftech_workshop.city.CityEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name = "country", schema = "public", catalog = "world-db")
public class CountryEntity{

    @Id
    @Column(name = "code", columnDefinition = "character(3) NOT NULL")
    private String code;
    @Column(name = "name", columnDefinition = "text NOT NULL")
    private String name;
    @Column(name = "continent", columnDefinition = "text NOT NULL")
    private String continent;
    @Column(name = "region", columnDefinition = "text NOT NULL")
    private String region;
    @Column(name = "surface_area", columnDefinition = "real NOT NULL")
    private float surfaceArea;
    @Column(name = "indep_year", columnDefinition = "smallint")
    private Short indepYear;
    @Column(name = "population", columnDefinition = "integer NOT NULL")
    private int population;
    @Column(name = "life_expectancy", columnDefinition = "real")
    private Float lifeExpectancy;
    @Column(name = "gnp", columnDefinition = "numeric(10,2)")
    private BigDecimal gnp;
    @Column(name = "gnp_old", columnDefinition = "numeric(10,2)")
    private BigDecimal gnpOld;
    @Column(name = "local_name", columnDefinition = "text NOT NULL")
    private String localName;
    @Column(name = "government_form", columnDefinition = "text NOT NULL")
    private String governmentForm;
    @Column(name = "head_of_state", columnDefinition = "text")
    private String headOfState;
    @Column(name = "code2", columnDefinition = "character(2) NOT NULL")
    private String code2;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "capital")
    private CityEntity capital;

    public CountryEntity() {
    }

    public CountryEntity(String code, String name, String continent, String region, float surfaceArea, Short indepYear, int population, Float lifeExpectancy, BigDecimal gnp, BigDecimal gnpOld, String localName, String governmentForm, String headOfState, String code2) {
        this.code = code;
        this.name = name;
        this.continent = continent;
        this.region = region;
        this.surfaceArea = surfaceArea;
        this.indepYear = indepYear;
        this.population = population;
        this.lifeExpectancy = lifeExpectancy;
        this.gnp = gnp;
        this.gnpOld = gnpOld;
        this.localName = localName;
        this.governmentForm = governmentForm;
        this.headOfState = headOfState;
        this.code2 = code2;
    }

    private String getCode() {
        return code;
    }

    String getName() {
        return name;
    }

    String getContinent() {
        return continent;
    }

    private String getRegion() {
        return region;
    }

    private float getSurfaceArea() {
        return surfaceArea;
    }

    private Short getIndepYear() {
        return indepYear;
    }

    int getPopulation() {
        return population;
    }

    Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    private BigDecimal getGnp() {
        return gnp;
    }

    private BigDecimal getGnpOld() {
        return gnpOld;
    }

    private String getLocalName() {
        return localName;
    }

    private String getGovernmentForm() {
        return governmentForm;
    }

    private String getHeadOfState() {
        return headOfState;
    }

    private String getCode2() {
        return code2;
    }

    private CityEntity getCapital() {
        return capital;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryEntity)) return false;
        CountryEntity that = (CountryEntity) o;
        return Float.compare(that.getSurfaceArea(), getSurfaceArea()) == 0 &&
                getPopulation() == that.getPopulation() &&
                getCode().equals(that.getCode()) &&
                getName().equals(that.getName()) &&
                getContinent().equals(that.getContinent()) &&
                Objects.equals(getRegion(), that.getRegion()) &&
                Objects.equals(getIndepYear(), that.getIndepYear()) &&
                Objects.equals(getLifeExpectancy(), that.getLifeExpectancy()) &&
                Objects.equals(getGnp(), that.getGnp()) &&
                Objects.equals(getGnpOld(), that.getGnpOld()) &&
                Objects.equals(getLocalName(), that.getLocalName()) &&
                Objects.equals(getGovernmentForm(), that.getGovernmentForm()) &&
                Objects.equals(getHeadOfState(), that.getHeadOfState()) &&
                getCode2().equals(that.getCode2());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(),
                getName(),
                getContinent(),
                getRegion(),
                getSurfaceArea(),
                getIndepYear(),
                getPopulation(),
                getLifeExpectancy(),
                getGnp(),
                getGnpOld(),
                getLocalName(),
                getGovernmentForm(),
                getHeadOfState(),
                getCode2(),
                getCapital());
    }
}
