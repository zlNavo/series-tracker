package de.seriestracker.person;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public final class PersonService {

    private final PersonRepository personRepository;

    public PersonService(final PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public PersonDTO registerPerson(final PersonDTOSimple personDTOSimple) {
        Person person = PersonEntityMapper.personDTOSimpleToPerson(personDTOSimple);
        return PersonEntityMapper.personToPersonDTO(personRepository.save(person));
    }

    public PersonDTO getPersonById(final Long id) {
        return PersonEntityMapper.personToPersonDTO(personRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id %d not found", id))
        ));
    }

    public List<PersonDTO> getAllPersons() {
        List<Person> persons = (List<Person>) personRepository.findAll();
        return persons.stream().map(PersonEntityMapper::personToPersonDTO).toList();
    }

    public PersonDTO updatePerson(final Long id, final PersonDTOSimple personDTOSimple) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id %d not found", id))
        );

        person.setFirstName(personDTOSimple.firstName());
        person.setLastName(personDTOSimple.lastName());
        person.setGender(personDTOSimple.gender());

        if (personDTOSimple.birthdate() == null) {
            person.setBirthdate(null);
        } else {
            person.setBirthdate(personDTOSimple.birthdate());
        }

        if (personDTOSimple.birthplace() == null || personDTOSimple.birthplace().isEmpty()) {
            person.setBirthplace(null);
        } else {
            person.setBirthplace(personDTOSimple.birthplace());
        }

        return PersonEntityMapper.personToPersonDTO(personRepository.save(person));
    }

    public PersonDTO deletePerson(final Long id) {
        Person person = personRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Person with id %d not found", id))
        );
        personRepository.delete(person);

        return PersonEntityMapper.personToPersonDTO(person);
    }
}