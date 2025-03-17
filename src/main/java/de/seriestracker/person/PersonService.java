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
        if (!personRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person with given Id does not exist");
        }
        return PersonEntityMapper.personToPersonDTO(personRepository.findById(id).orElse(null));
    }

    public List<PersonDTO> getAllPersons() {
        List<Person> personList = (List<Person>) personRepository.findAll();
        return personList.stream().map(PersonEntityMapper::personToPersonDTO).toList();
    }

    public PersonDTO updatePerson(final Long id, final PersonDTOSimple personDTOSimple) {
        if (id == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Person id may not be null");
        }

        Person person = personRepository.findById(id).orElse(null);
        if (person == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Person with given Id does not exist");
        }

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
}