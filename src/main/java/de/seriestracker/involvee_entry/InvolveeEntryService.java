package de.seriestracker.involvee_entry;

import de.seriestracker.media.movie.Movie;
import de.seriestracker.media.movie.MovieRepository;
import de.seriestracker.person.Person;
import de.seriestracker.person.PersonRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public final class InvolveeEntryService {

    private final InvolveeEntryRepository involveeEntryRepository;
    private final PersonRepository personRepository;
    private final MovieRepository movieRepository;

    public InvolveeEntryService(final InvolveeEntryRepository involveeEntryRepository, final PersonRepository personRepository, final MovieRepository movieRepository) {
        this.involveeEntryRepository = involveeEntryRepository;
        this.personRepository = personRepository;
        this.movieRepository = movieRepository;
    }

    public InvolveeEntryDTO registerInvolveeEntry(final InvolveeEntryDTOSimple involveeEntryDTOSimple) {
        Person person = personRepository.findById(involveeEntryDTOSimple.personId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id %d not found", involveeEntryDTOSimple.personId()))
        );

        Movie movie = movieRepository.findById(involveeEntryDTOSimple.movieId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", involveeEntryDTOSimple.movieId()))
        );

        //TODO refactor into entity mapper
        InvolveeEntry involveeEntry  = new InvolveeEntry(person, movie, involveeEntryDTOSimple.roleType(), involveeEntryDTOSimple.role());

        return InvolveeEntryEntityMapper.involveeEntryToInvolveeEntryDTO(involveeEntryRepository.save(involveeEntry));
    }

    public InvolveeEntryDTO getInvolveeEntryById(final Long id) {
        return InvolveeEntryEntityMapper.involveeEntryToInvolveeEntryDTO(involveeEntryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Involvee entry with id %d not found", id))
        ));
    }

    public List<InvolveeEntryDTO> getAllInvolveeEntries() {
        List<InvolveeEntry> involveeEntries = (List<InvolveeEntry>) involveeEntryRepository.findAll();
        return involveeEntries.stream().map(InvolveeEntryEntityMapper::involveeEntryToInvolveeEntryDTO).toList();
    }

    public List<InvolveeEntryDTO> getInvolveeEntriesByPersonId(final Long personId) {
        Person person = personRepository.findById(personId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id %d not found", personId))
        );

        List<InvolveeEntry> involveeEntries = involveeEntryRepository.findAllByPerson(person);

        return involveeEntries.stream().map(InvolveeEntryEntityMapper::involveeEntryToInvolveeEntryDTO).toList();
    }

    public List<InvolveeEntryDTO> getInvolveeEntriesByMovieId(final Long movieId) {
        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", movieId))
        );

        List<InvolveeEntry> involveeEntries = involveeEntryRepository.findAllByMovie(movie);

        return involveeEntries.stream().map(InvolveeEntryEntityMapper::involveeEntryToInvolveeEntryDTO).toList();
    }

    public InvolveeEntryDTO updateInvolveeEntry(final Long id, final InvolveeEntryDTOSimple involveeEntryDTOSimple) {
        InvolveeEntry involveeEntry = involveeEntryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Involvee entry with id %d not found", id))
        );

        Person person = personRepository.findById(involveeEntryDTOSimple.personId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id %d not found", involveeEntryDTOSimple.personId()))
        );

        Movie movie = movieRepository.findById(involveeEntryDTOSimple.movieId()).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", involveeEntryDTOSimple.movieId()))
        );

        involveeEntry.setPerson(person);
        involveeEntry.setMovie(movie);
        involveeEntry.setRoleType(involveeEntryDTOSimple.roleType());
        involveeEntry.setRole(involveeEntryDTOSimple.role());

        return InvolveeEntryEntityMapper.involveeEntryToInvolveeEntryDTO(involveeEntryRepository.save(involveeEntry));
    }

    public InvolveeEntryDTO deleteInvolveeEntry(final Long id) {
        InvolveeEntry involveeEntry = involveeEntryRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("InvolveeEntry with id %d not found", id))
        );
        involveeEntryRepository.delete(involveeEntry);
        return InvolveeEntryEntityMapper.involveeEntryToInvolveeEntryDTO(involveeEntry);
    }

    public InvolveeEntryDTO deleteInvolveeEntryByPersonAndMovieId(final Long personId, final Long movieId) {
        Person person = personRepository.findById(personId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id %d not found", personId))
        );

        Movie movie = movieRepository.findById(movieId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Movie with id %d not found", movieId))
        );

        InvolveeEntry involveeEntry = involveeEntryRepository.findByPersonAndMovie(person, movie);

        involveeEntryRepository.delete(involveeEntry);

        return InvolveeEntryEntityMapper.involveeEntryToInvolveeEntryDTO(involveeEntry);
    }

}
