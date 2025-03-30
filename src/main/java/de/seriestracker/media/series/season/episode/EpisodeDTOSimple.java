package de.seriestracker.media.series.season.episode;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record EpisodeDTOSimple(
        @Size(max = 256)
        String title,
        @NotEmpty
        @Size(max = 1024)
        String description,
        LocalDate premiereDate,
        Long seasonId
) {
}
