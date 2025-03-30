package de.seriestracker.involvee_entry;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

//@EitherOr(fields = {"episode", "movie"})
public record InvolveeEntryDTOSimple(
        @NotNull
        Long personId,
        //Long episodeId,
        Long movieId,
        @Enumerated(EnumType.STRING)
        Role roleType,
        String role
) {
}
