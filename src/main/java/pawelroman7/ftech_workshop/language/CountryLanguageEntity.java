package pawelroman7.ftech_workshop.language;

import pawelroman7.ftech_workshop.country.CountryEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "country_language", schema = "public", catalog = "world-db")
public class CountryLanguageEntity {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "country_code")
    private CountryEntity code;
    @Id
    @Column(name = "language", columnDefinition = "text NOT NULL")
    private String language;
    @Column(name = "is_official", columnDefinition = "boolean NOT NULL")
    private boolean isOfficial;
    @Column(name = "percentage", columnDefinition = "real NOT NULL")
    private float percentage;

    public CountryLanguageEntity() {
    }

    private CountryEntity getCode() {
        return code;
    }

    public String getLanguage() {
        return language;
    }

    private boolean isOfficial() {
        return isOfficial;
    }

    private float getPercentage() {
        return percentage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CountryLanguageEntity)) return false;
        CountryLanguageEntity that = (CountryLanguageEntity) o;
        return isOfficial() == that.isOfficial() &&
                Float.compare(that.getPercentage(), getPercentage()) == 0 &&
                getCode().equals(that.getCode()) &&
                getLanguage().equals(that.getLanguage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCode(),
                getLanguage(),
                isOfficial(),
                getPercentage());
    }

    @Override
    public String toString() {
        return language;
    }
}
