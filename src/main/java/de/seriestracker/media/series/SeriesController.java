package de.seriestracker.media.series;

import de.seriestracker.media.series.season.SeasonDTO;
import de.seriestracker.media.series.season.SeasonDTOSimple;
import de.seriestracker.media.series.season.episode.EpisodeDTO;
import de.seriestracker.media.series.season.episode.EpisodeDTOSimple;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public final class SeriesController {
    private SeriesService seriesService;

    public SeriesController(final SeriesService seriesService) {
        this.seriesService = seriesService;
    }

    @PostMapping("/series")
    public ResponseEntity<SeriesDTO> registerSeries(@Valid @RequestBody final SeriesDTOSimple requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(seriesService.registerSeries(requestBody));
    }

    @PostMapping("/series/seasons")
    public ResponseEntity<SeasonDTO> registerSeason(@Valid @RequestBody final SeasonDTOSimple requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(seriesService.registerSeason(requestBody));
    }

    @PostMapping("/series/seasons/episodes")
    public ResponseEntity<EpisodeDTO> registerEpisode(@Valid @RequestBody final EpisodeDTOSimple requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(seriesService.registerEpisode(requestBody));
    }

    @GetMapping("/series")
    public ResponseEntity<List<SeriesDTO>> getAllSeries() {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.getAllSeries());
    }

    @GetMapping("/series/{id}")
    public ResponseEntity<SeriesDTO> getSeriesById(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.getSeriesById(id));
    }

    @GetMapping("/series/{id}/seasons")
    public ResponseEntity<List<SeasonDTO>> getAllSeasonsBySeriesById(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.getAllSeasonsBySeriesId(id));
    }

    @GetMapping("/series/{id}/seasons/episodes")
    public ResponseEntity<List<EpisodeDTO>> getAllEpisodesBySeriesById(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.getAllEpisodesBySeriesId(id));
    }

    @GetMapping("/series/seasons/{id}/episodes")
    public ResponseEntity<List<EpisodeDTO>> getAllEpisodesBySeasonById(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.getAllEpisodesBySeasonId(id));
    }

    @PutMapping("/series/{id}")
    public ResponseEntity<SeriesDTO> updateSeries(@PathVariable final Long id, @Valid @RequestBody final SeriesDTOSimple requestBody) {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.updateSeries(id, requestBody));
    }

    @PutMapping("/series/seasons/episodes/{id}")
    public ResponseEntity<EpisodeDTO> updateEpisode(@PathVariable final Long id, @Valid @RequestBody final EpisodeDTOSimple requestBody) {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.updateEpisode(id, requestBody));
    }

    @DeleteMapping("/series/{id}")
    public ResponseEntity<SeriesDTO> deleteSeries(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.deleteSeries(id));
    }

    @DeleteMapping("/series/seasons/{id}")
    public ResponseEntity<SeasonDTO> deleteSeason(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.deleteSeason(id));
    }

    @DeleteMapping("/series/seasons/episodes/{id}")
    public ResponseEntity<EpisodeDTO> deleteEpisode(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(seriesService.deleteEpisode(id));
    }
}
