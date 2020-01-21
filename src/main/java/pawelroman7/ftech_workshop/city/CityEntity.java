package pawelroman7.ftech_workshop.city;

import pawelroman7.ftech_workshop.country.CountryEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "public", catalog = "world-db")
public class CityEntity {

    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "district")
    private String district;
    @Column(name = "population")
    private int population;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code")
    private CountryEntity country;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CityEntity)) return false;
        CityEntity that = (CityEntity) o;
        return getId() == that.getId() &&
                getPopulation() == that.getPopulation() &&
                getName().equals(that.getName()) &&
                getDistrict().equals(that.getDistrict()) &&
                Objects.equals(getCountry(), that.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDistrict(), getPopulation());
    }
}
