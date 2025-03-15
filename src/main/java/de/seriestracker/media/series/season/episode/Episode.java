package de.seriestracker.media.series.season.episode;

import de.seriestracker.media.Genre;
import de.seriestracker.media.Media;
import de.seriestracker.media.series.season.Season;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "episode")
public final class Episode extends Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "season_id")
    private Season season;

    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "genres", joinColumns = @JoinColumn(name = "media_id"))
    @Column(name = "genres")
    @Enumerated(EnumType.STRING)
    private List<Genre> genres = new ArrayList<>();

}
