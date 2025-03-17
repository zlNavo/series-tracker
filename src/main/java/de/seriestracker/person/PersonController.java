package de.seriestracker.person;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public final class PersonController {

    private PersonService personService;

    public PersonController(final PersonService personService) {
        this.personService = personService;
    }

    @PostMapping("/persons")
    public ResponseEntity<PersonDTO> registerPerson(@Valid @RequestBody final PersonDTOSimple requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(personService.registerPerson(requestBody));
    }

    @GetMapping("/persons")
    public ResponseEntity<List<PersonDTO>> getAllPersons() {
        return ResponseEntity.ok(personService.getAllPersons());
    }

    @GetMapping("/persons/{id}")
    public ResponseEntity<PersonDTO> getPersonById(@PathVariable final Long id) {
        return ResponseEntity.ok(personService.getPersonById(id));
    }

    @PutMapping("/persons/{id}")
    public ResponseEntity<PersonDTO> updatePerson(@PathVariable final Long id, final @Valid @RequestBody PersonDTOSimple requestBody) {
        return ResponseEntity.ok(personService.updatePerson(id, requestBody));
    }
}
