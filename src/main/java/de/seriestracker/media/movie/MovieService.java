package de.seriestracker.media.movie;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public final class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    public MovieDTO registerMovie(final MovieDTOSimple movieDTOSimple) {
        Movie movie = MovieEntityMapper.movieDTOSimpleToMovie(movieDTOSimple);
        return MovieEntityMapper.movieToMovieDTO(movieRepository.save(movie));
    }

    public MovieDTO getMovieById(final Long id) {
        return MovieEntityMapper.movieToMovieDTO(movieRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", id)))
        );
    }

    public List<MovieDTO> getAllMovies() {
        List<Movie> movieList = (List<Movie>) movieRepository.findAll();
        return movieList.stream().map(MovieEntityMapper::movieToMovieDTO).toList();
    }

    public MovieDTO updateMovie(final Long id, final MovieDTOSimple movieDTOSimple) {
        Movie movie = movieRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", id))
        );

        movie.setTitle(movieDTOSimple.title());
        movie.setDescription(movieDTOSimple.description());
        movie.setPremiereDate(movieDTOSimple.premiereDate());
        movie.setGenres(movieDTOSimple.genres());

        return MovieEntityMapper.movieToMovieDTO(movieRepository.save(movie));
    }

    public MovieDTO deleteMovie(final Long id) {
        Movie movie = movieRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", id))
        );
        movieRepository.delete(movie);
        return MovieEntityMapper.movieToMovieDTO(movie);
    }
}
