package de.seriestracker.involvee_entry;

import de.seriestracker.media.movie.Movie;
import de.seriestracker.media.series.season.episode.Episode;
import de.seriestracker.person.Person;

import jakarta.persistence.*;

@Entity
@Table(name = "involvee_entry")
public final class InvolveeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "episode_id")
    private Episode episode;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;



}
