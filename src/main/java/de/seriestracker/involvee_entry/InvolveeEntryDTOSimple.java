package de.seriestracker.involvee_entry;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record InvolveeEntryDTOSimple(
        @NotNull
        Long personId,
        Long movieId,
        @Enumerated(EnumType.STRING)
        Role roleType,
        String role
) {
}
