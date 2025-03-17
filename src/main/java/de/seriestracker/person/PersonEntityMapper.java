package de.seriestracker.person;

public final class PersonEntityMapper {
    public static Person personDTOSimpleToPerson(PersonDTOSimple personDTOSimple) {
        Person person = new Person(personDTOSimple.firstName(), personDTOSimple.lastName(), personDTOSimple.gender(),
                personDTOSimple.birthdate(), personDTOSimple.birthplace());
        return person;
    }
    public static PersonDTO personToPersonDTO(Person person) {
        PersonDTO personDTO = new PersonDTO(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(),
                person.getBirthdate(), person.getBirthplace());
        return personDTO;
    }

}
