package de.seriestracker.person;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

public record PersonDTO(
        Long id,
        @NotEmpty(message = "First name of the person may not be null")
        @Size(max = 64, message = "Length of first name may not be longer than 64 characters")
        String firstName,
        @NotEmpty(message = "Last name of the person may not be null")
        @Size(max = 64, message = "Length of first name may not be longer than 64 characters")
        String lastName,
        @Enumerated(EnumType.STRING)
        Gender gender,
        LocalDate birthdate,
        String birthplace
) {
}
