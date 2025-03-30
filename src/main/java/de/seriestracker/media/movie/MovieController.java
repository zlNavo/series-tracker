package de.seriestracker.media.movie;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public final class MovieController {

    private final MovieService movieService;

    public MovieController(final MovieService movieService) {
        this.movieService = movieService;
    }

    @PostMapping("/movies")
    public ResponseEntity<MovieDTO> registerMovie(@Valid @RequestBody final MovieDTOSimple requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(movieService.registerMovie(requestBody));
    }

    @GetMapping("/movies")
    public ResponseEntity<List<MovieDTO>> getMovies() {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getAllMovies());
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<MovieDTO> getMovie(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.getMovieById(id));
    }

    @PutMapping("/movies/{id}")
    public ResponseEntity<MovieDTO> updateMovie(@PathVariable final Long id, @Valid @RequestBody final MovieDTOSimple requestBody) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.updateMovie(id, requestBody));
    }

    @DeleteMapping("/movies/{id}")
    public ResponseEntity<MovieDTO> deleteMovie(@PathVariable final Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(movieService.deleteMovie(id));
    }
}
