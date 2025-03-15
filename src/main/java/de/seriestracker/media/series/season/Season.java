package de.seriestracker.media.series.season;

import de.seriestracker.media.Media;
import de.seriestracker.media.series.Series;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "season")
public final class Season extends Media {

    @ManyToOne
    @JoinColumn(name = "series_id")
    private Series series;

    @Column(name = "end_date")
    private Date endDate;
}
