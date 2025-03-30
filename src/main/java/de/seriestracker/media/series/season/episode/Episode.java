package de.seriestracker.media.series.season.episode;

import de.seriestracker.media.Media;
import de.seriestracker.media.series.season.Season;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "episode")
public final class Episode extends Media {
    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    public Episode() {}

    public Episode(final String title, final String description, final LocalDate premiereDate, final Season season) {
        super(title, description, premiereDate);
        this.season = season;
    }

    public Season getSeason() {
        return season;
    }
}
