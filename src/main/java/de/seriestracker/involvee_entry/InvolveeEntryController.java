package de.seriestracker.involvee_entry;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvolveeEntryController {

    private InvolveeEntryService involveeEntryService;

    public InvolveeEntryController(final InvolveeEntryService involveeEntryService) {
        this.involveeEntryService = involveeEntryService;
    }

    @PostMapping("/involvee_entries")
    public ResponseEntity<InvolveeEntryDTO> registerInvolveeEntry(@Valid @RequestBody InvolveeEntryDTOSimple requestBody) {
        return ResponseEntity.status(HttpStatus.CREATED).body(involveeEntryService.registerInvolveeEntry(requestBody));
    }

    @GetMapping("/involvee_entries/{id}")
    public ResponseEntity<InvolveeEntryDTO> getInvolveeEntry(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(involveeEntryService.getInvolveeEntryById(id));
    }

    @GetMapping("/involvee_entries")
    public ResponseEntity<List<InvolveeEntryDTO>> getAllInvolveeEntries() {
        return ResponseEntity.status(HttpStatus.OK).body(involveeEntryService.getAllInvolveeEntries());
    }

    @GetMapping("/person/involvee_entries/{id}")
    public ResponseEntity<List<InvolveeEntryDTO>> getInvolveeEntryByPersonId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(involveeEntryService.getInvolveeEntriesByPersonId(id));
    }

    @GetMapping("/movie/involvee_entries/{id}")
    public ResponseEntity<List<InvolveeEntryDTO>> getInvolveeEntryByMovieId(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(involveeEntryService.getInvolveeEntriesByMovieId(id));
    }

    @PutMapping("/involvee_entries/{id}")
    public ResponseEntity<InvolveeEntryDTO> updateInvolveeEntry(@PathVariable Long id, @Valid @RequestBody InvolveeEntryDTOSimple requestBody) {
        return ResponseEntity.status(HttpStatus.OK).body(involveeEntryService.updateInvolveeEntry(id, requestBody));
    }

    @DeleteMapping("/involvee_entries/{id}")
    public ResponseEntity<InvolveeEntryDTO> deleteInvolveeEntry(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(involveeEntryService.deleteInvolveeEntry(id));
    }

    @DeleteMapping("/involvee_entries/{personId}/{movieId}")
    public ResponseEntity<InvolveeEntryDTO> deleteInvolveeEntryByPersonAndMovieId(@PathVariable Long personId, @PathVariable Long movieId) {
        return ResponseEntity.status(HttpStatus.OK).body(involveeEntryService.deleteInvolveeEntryByPersonAndMovieId(personId, movieId));
    }
}
