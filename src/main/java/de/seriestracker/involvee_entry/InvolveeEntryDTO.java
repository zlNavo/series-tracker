package de.seriestracker.involvee_entry;

import de.seriestracker.media.movie.Movie;
import de.seriestracker.person.Person;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

public record InvolveeEntryDTO(
        Long id,
        Person person,
        Movie movie,
        @Enumerated(EnumType.STRING)
        Role roleType,
        String role
) {
}
