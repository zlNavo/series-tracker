package de.seriestracker.media.series;

import de.seriestracker.media.Genre;
import de.seriestracker.media.Media;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Value;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "series")
public final class Series extends Media {

    @Value("${series.genres:@null}")
    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Column(name = "genres")
    private List<Genre> genres;

    public Series() {}

    public Series(final String title, final String description, final LocalDate premiereDate, final List<Genre> genres) {
        super(title, description, premiereDate);
        this.genres = genres;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(final List<Genre> genres) {
        this.genres = genres;
    }
}
