package de.seriestracker.person;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public final class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastname;

    @Column(name = "gender")
    private Gender gender;

    @Column(name = "birthdate")
    private Date birthdate;

    @Column(name = "birthplace")
    private String birthplace;

}
