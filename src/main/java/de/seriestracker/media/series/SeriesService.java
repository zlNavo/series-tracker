package de.seriestracker.media.series;

import de.seriestracker.media.series.season.*;
import de.seriestracker.media.series.season.episode.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public final class SeriesService {

    private final SeriesRepository seriesRepository;
    private final SeasonRepository seasonRepository;
    private final EpisodeRepository episodeRepository;

    public SeriesService(final SeriesRepository seriesRepository, final SeasonRepository seasonRepository, final EpisodeRepository episodeRepository) {
        this.seriesRepository = seriesRepository;
        this.seasonRepository = seasonRepository;
        this.episodeRepository = episodeRepository;
    }

    public SeriesDTO registerSeries(final SeriesDTOSimple seriesDTOSimple) {
        Series series = SeriesEntityMapper.SeriesDTOSimpleToSeries(seriesDTOSimple);
        return SeriesEntityMapper.SeriesToSeriesDTO(seriesRepository.save(series));
    }

    public SeasonDTO registerSeason(final SeasonDTOSimple seasonDTOsimple) {
        Series series = seriesRepository.findById(seasonDTOsimple.seriesId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Series with id %d not found", seasonDTOsimple.seriesId()))
        );
        Season season = new Season(series);
        return SeasonEntityMapper.seasonToSeasonDTO(seasonRepository.save(season));
    }

    public EpisodeDTO registerEpisode(final EpisodeDTOSimple episodeDTOSimple) {
        Season season = seasonRepository.findById(episodeDTOSimple.seasonId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Season with id %d not found", episodeDTOSimple.seasonId()))
        );
        //TODO refactor into entity mapper
        Episode episode = new Episode(episodeDTOSimple.title(), episodeDTOSimple.description(), episodeDTOSimple.premiereDate(), season);
        return EpisodeEntityMapper.episodeToEpisodeDTO(episodeRepository.save(episode));
    }

    public List<SeriesDTO> getAllSeries() {
        List<Series> series = (List<Series>) seriesRepository.findAll();
        return series.stream().map(SeriesEntityMapper::SeriesToSeriesDTO).toList();
    }

    public SeriesDTO getSeriesById(final Long id) {
        Series series = seriesRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Series with id %d not found", id))
        );

        return SeriesEntityMapper.SeriesToSeriesDTO(series);
    }


    public List<SeasonDTO> getAllSeasonsBySeriesId(final Long id) {
        Series series = seriesRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Series with id %d not found", id))
        );

        List<Season> seasons = seasonRepository.findSeasonsBySeries(series);

        return seasons.stream().map(SeasonEntityMapper::seasonToSeasonDTO).toList();
    }

    public List<EpisodeDTO> getAllEpisodesBySeriesId(final Long id) {
        Series series = seriesRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Series with id %d not found", id))
        );
        
        List<Season> seasons = seasonRepository.findSeasonsBySeries(series);

        List<Episode> episodes = new ArrayList<>();
        
        for (Season season : seasons) {
            episodes.addAll(episodeRepository.findBySeason(season));
        }

        return episodes.stream().map(EpisodeEntityMapper::episodeToEpisodeDTO).toList();
    }

    public List<EpisodeDTO> getAllEpisodesBySeasonId(final Long id) {
        Season season = seasonRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Season with id %d not found", id))
        );

        List<Episode> episodes = episodeRepository.findBySeason(season);

        return episodes.stream().map(EpisodeEntityMapper::episodeToEpisodeDTO).toList();
    }

    public SeriesDTO updateSeries(final Long id, final SeriesDTOSimple seriesDTOSimple) {
        Series series = seriesRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Series with id %d not found", id))
        );

        series.setTitle(seriesDTOSimple.title());
        series.setDescription(seriesDTOSimple.description());
        series.setPremiereDate(seriesDTOSimple.premiereDate());
        series.setGenres(seriesDTOSimple.genres());

        return SeriesEntityMapper.SeriesToSeriesDTO(seriesRepository.save(series));
    }

    public EpisodeDTO updateEpisode(final Long id, final EpisodeDTOSimple episodeDTOSimple) {
        Episode episode = episodeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Episode with id %d not found", id))
        );

        episode.setTitle(episodeDTOSimple.title());
        episode.setDescription(episodeDTOSimple.description());
        episode.setPremiereDate(episodeDTOSimple.premiereDate());

        return EpisodeEntityMapper.episodeToEpisodeDTO(episodeRepository.save(episode));
    }

    public SeriesDTO deleteSeries(final Long id) {
        Series series = seriesRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Series with id %d not found", id))
        );

        seriesRepository.delete(series);

        return SeriesEntityMapper.SeriesToSeriesDTO(series);
    }

    public SeasonDTO deleteSeason(final Long id) {
        Season season = seasonRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Season with id %d not found", id))
        );

        seasonRepository.delete(season);

        return SeasonEntityMapper.seasonToSeasonDTO(season);
    }

    public EpisodeDTO deleteEpisode(final Long id) {
        Episode episode = episodeRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Episode with id %d not found", id))
        );

        episodeRepository.delete(episode);

        return EpisodeEntityMapper.episodeToEpisodeDTO(episode);
    }


}
