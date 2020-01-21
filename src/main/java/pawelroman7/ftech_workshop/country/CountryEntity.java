package pawelroman7.ftech_workshop.country;

import pawelroman7.ftech_workshop.city.CityEntity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "country", schema = "public", catalog = "world-db")
public class CountryEntity {

    @Id
    @Column(name = "code")
    private String code;
    @Column(name = "name")
    private String name;
    @Column(name = "continent")
    private String continent;
    @Column(name = "region")
    private String region;
    @Column(name = "surface_area")
    private float surfaceArea;
    @Column(name = "indep_year")
    private Short indepYear;
    @Column(name = "population")
    private int population;
    @Column(name = "life_expectancy")
    private Float lifeExpectancy;
    @Column(name = "gnp")
    private BigDecimal gnp;
    @Column(name = "gnp_old")
    private BigDecimal gnpOld;
    @Column(name = "local_name")
    private String localName;
    @Column(name = "government_form")
    private String governmentForm;
    @Column(name = "head_of_state")
    private String headOfState;
    @Column(name = "code2")
    private String code2;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "capital")
    private CityEntity capital;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public float getSurfaceArea() {
        return surfaceArea;
    }

    public void setSurfaceArea(float surfaceArea) {
        this.surfaceArea = surfaceArea;
    }

    public Short getIndepYear() {
        return indepYear;
    }

    public void setIndepYear(Short indepYear) {
        this.indepYear = indepYear;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public Float getLifeExpectancy() {
        return lifeExpectancy;
    }

    public void setLifeExpectancy(Float lifeExpectancy) {
        this.lifeExpectancy = lifeExpectancy;
    }

    public BigDecimal getGnp() {
        return gnp;
    }

    public void setGnp(BigDecimal gnp) {
        this.gnp = gnp;
    }

    public BigDecimal getGnpOld() {
        return gnpOld;
    }

    public void setGnpOld(BigDecimal gnpOld) {
        this.gnpOld = gnpOld;
    }

    public String getLocalName() {
        return localName;
    }

    public void setLocalName(String localName) {
        this.localName = localName;
    }

    public String getGovernmentForm() {
        return governmentForm;
    }

    public void setGovernmentForm(String governmentForm) {
        this.governmentForm = governmentForm;
    }

    public String getHeadOfState() {
        return headOfState;
    }

    public void setHeadOfState(String headOfState) {
        this.headOfState = headOfState;
    }

    public String getCode2() {
        return code2;
    }

    public void setCode2(String code2) {
        this.code2 = code2;
    }

    public CityEntity getCapital() {
        return capital;
    }

    public void setCapital(CityEntity capital) {
        this.capital = capital;
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
                getCode2().equals(that.getCode2()) &&
                getCapital().equals(that.getCapital());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(), getName(), getContinent(), getRegion(), getSurfaceArea(), getIndepYear(), getPopulation(), getLifeExpectancy(), getGnp(), getGnpOld(), getLocalName(), getGovernmentForm(), getHeadOfState(), getCode2(), getCapital());
    }
}
