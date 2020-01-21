package pawelroman7.ftech_workshop.language;

import pawelroman7.ftech_workshop.country.CountryEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "country_language", schema = "public", catalog = "world-db")
public class CountryLanguageEntity {

    @Id
    @ManyToOne
    @PrimaryKeyJoinColumn(name = "country_code")
    private CountryEntity country;
    @Column(name = "language")
    private String language;
    @Column(name = "is_official")
    private boolean isOfficial;
    @Column(name = "percentage")
    private float percentage;

    public CountryEntity getCountry() {
        return country;
    }

    public void setCountry(CountryEntity country) {
        this.country = country;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public boolean isOfficial() {
        return isOfficial;
    }

    public void setOfficial(boolean official) {
        isOfficial = official;
    }

    public float getPercentage() {
        return percentage;
    }

    public void setPercentage(float percentage) {
        this.percentage = percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryLanguageEntity)) return false;
        CountryLanguageEntity that = (CountryLanguageEntity) o;
        return isOfficial() == that.isOfficial() &&
                Float.compare(that.getPercentage(), getPercentage()) == 0 &&
                getCountry().equals(that.getCountry()) &&
                getLanguage().equals(that.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCountry(), getLanguage(), isOfficial(), getPercentage());
    }
}
