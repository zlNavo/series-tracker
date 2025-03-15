package de.seriestracker.media.movie;

import de.seriestracker.media.Genre;
import de.seriestracker.media.Media;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "movie")
public final class Movie extends Media {

    @ElementCollection(targetClass = Genre.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "genres", joinColumns = @JoinColumn(name = "media_id"))
    @Column(name = "genres")
    @Enumerated(EnumType.STRING)
    private List<Genre> genres = new ArrayList<>();
}
