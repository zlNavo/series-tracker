package de.seriestracker.involvee_entry;

import de.seriestracker.media.movie.Movie;
import de.seriestracker.person.Person;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvolveeEntryRepository extends CrudRepository<InvolveeEntry, Long> {
    List<InvolveeEntry> findAllByPerson(Person person);

    List<InvolveeEntry> findAllByMovie(Movie movie);

    InvolveeEntry findByPersonAndMovie(Person person, Movie movie);
}
