package de.seriestracker.media.series;

public final class SeriesEntityMapper {
    public static Series SeriesDTOSimpleToSeries(final SeriesDTOSimple seriesDTOSimple) {
        return new Series(seriesDTOSimple.title(), seriesDTOSimple.description(), seriesDTOSimple.premiereDate(), seriesDTOSimple.genres());
    }

    public static SeriesDTO SeriesToSeriesDTO(final Series series) {
        return new SeriesDTO(series.getId(), series.getTitle(), series.getDescription(), series.getPremiereDate(), series.getGenres());
    }
}
