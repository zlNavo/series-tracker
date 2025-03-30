package de.seriestracker.involvee_entry;

import de.seriestracker.media.movie.Movie;
import de.seriestracker.person.Person;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;

//@EitherOr(fields = {"episode", "movie"})
public record InvolveeEntryDTO(
        Long id,
        Person person,
        //Episode episode,
        Movie movie,
        @Enumerated(EnumType.STRING)
        Role roleType,
        String role
) {
}
