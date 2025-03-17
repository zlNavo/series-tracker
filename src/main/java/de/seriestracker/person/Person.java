package de.seriestracker.person;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import java.time.LocalDate;

@Entity
public final class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "First name of the person may not be null")
    @Size(max = 64, message = "Length of first name may not be longer than 64 characters")
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty(message = "Last name of the person may not be null")
    @Size(max = 64, message = "Length of first name may not be longer than 64 characters")
    @Column(name = "last_name")
    private String lastName;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "birthplace")
    private String birthplace;

    public Person() {}

    public Person(final String firstName, final String lastName, final Gender gender, final LocalDate birthdate, final String birthplace) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.birthdate = birthdate;
        if (!birthplace.isEmpty())
        this.birthplace = birthplace;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(final String lastname) {
        this.lastName = lastname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(final Gender gender) {
        this.gender = gender;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(final LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getBirthplace() {
        return birthplace;
    }

    public void setBirthplace(final String birthplace) {
        this.birthplace = birthplace;
    }

}
