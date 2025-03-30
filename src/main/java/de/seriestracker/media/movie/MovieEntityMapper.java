package de.seriestracker.media.movie;

public final class MovieEntityMapper {
    public static Movie movieDTOSimpleToMovie(final MovieDTOSimple movieDTOSimple) {
        return new Movie(movieDTOSimple.title(), movieDTOSimple.description(), movieDTOSimple.premiereDate(),
                movieDTOSimple.genres());
    }
    public static MovieDTO movieToMovieDTO(final Movie movie) {
        return new MovieDTO(movie.getId(), movie.getTitle(), movie.getDescription(), movie.getPremiereDate(),
                movie.getGenres());
    }
}
