package de.seriestracker.media.movie;

import de.seriestracker.media.Genre;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;
import java.util.List;

public record MovieDTO(
        Long id,
        @NotEmpty
        @Size(max = 256)
        String title,
        @NotEmpty
        @Size(max = 1024)
        String description,
        LocalDate premiereDate,
        List<Genre> genres
) {
}
