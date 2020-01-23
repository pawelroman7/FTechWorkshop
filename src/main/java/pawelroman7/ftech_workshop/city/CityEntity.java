package pawelroman7.ftech_workshop.city;

import pawelroman7.ftech_workshop.country.CountryEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "city", schema = "public", catalog = "world-db")
public class CityEntity implements Serializable {

    @Id
    @Column(name = "id", columnDefinition = "integer NOT NULL")
    private int id;
    @Column(name = "name", columnDefinition = "text NOT NULL")
    private String name;
    @Column(name = "district", columnDefinition = "text NOT NULL")
    private String district;
    @Column(name = "population", columnDefinition = "integer NOT NULL")
    private int population;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code")
    private CountryEntity country;

    public CityEntity() {
    }

    private int getId() {
        return id;
    }

    private String getName() {
        return name;
    }

    private String getDistrict() {
        return district;
    }

    private int getPopulation() {
        return population;
    }

    public CountryEntity getCountry() {
        return country;
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
        return Objects.hash(getId(),
                getName(),
                getDistrict(),
                getPopulation());
    }
}
