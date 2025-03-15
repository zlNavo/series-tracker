package de.seriestracker.media.series;

import de.seriestracker.media.Media;

import jakarta.persistence.*;


@Entity
@Table(name = "series")
public final class Series extends Media {

    @Column(name = "season_amount")
    private Long seasonAmount;



}
