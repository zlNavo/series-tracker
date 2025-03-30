package de.seriestracker.person;

public final class PersonEntityMapper {
    public static Person personDTOSimpleToPerson(final PersonDTOSimple personDTOSimple) {
        return new Person(personDTOSimple.firstName(), personDTOSimple.lastName(), personDTOSimple.gender(),
                personDTOSimple.birthdate(), personDTOSimple.birthplace());
    }
    public static PersonDTO personToPersonDTO(final Person person) {
        return new PersonDTO(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(),
                person.getBirthdate(), person.getBirthplace());
    }

}
