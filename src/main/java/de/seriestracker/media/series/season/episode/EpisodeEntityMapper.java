package de.seriestracker.media.series.season.episode;

public final class EpisodeEntityMapper {
    public static EpisodeDTO episodeToEpisodeDTO(final Episode episode) {
        return new EpisodeDTO(episode.getId(), episode.getTitle(), episode.getDescription(), episode.getPremiereDate(), episode.getSeason());
    }
}
