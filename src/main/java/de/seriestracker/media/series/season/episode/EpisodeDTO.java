package de.seriestracker.media.series.season.episode;

import de.seriestracker.media.series.season.Season;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record EpisodeDTO(
        Long id,
        @Size(max = 256)
        String title,
        @NotEmpty
        @Size(max = 1024)
        String description,
        LocalDate premiereDate,
        Season season
) {
}
