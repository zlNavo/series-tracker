package de.seriestracker.media.series.season;

public final class SeasonEntityMapper {
    public static SeasonDTO seasonToSeasonDTO(final Season season) {
        return new SeasonDTO(season.getId(), season.getSeries());
    }
}
