package de.seriestracker.media.series.season;

import de.seriestracker.media.Media;
import de.seriestracker.media.series.Series;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "season")
public final class Season{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    public Season() {}

    public Season(final Series series) {
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public Series getSeries() {
        return series;
    }
}
