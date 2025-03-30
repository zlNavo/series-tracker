package de.seriestracker.involvee_entry;

import de.seriestracker.media.movie.Movie;
import de.seriestracker.person.Person;

import jakarta.persistence.*;

@Entity
@Table(name = "involvee_entry")
public final class InvolveeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type")
    private Role roleType;

    @Column(name = "role")
    private String role;

    public InvolveeEntry() {}

    public InvolveeEntry(final Person person, /*final Episode episode,*/ final Movie movie, final Role roleType, final String role) {
        this.person = person;
        // this.episode = episode;
        this.movie = movie;
        this.roleType = roleType;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(final Person person) {
        this.person = person;
    }

    /*
    public Episode getEpisode() {
        return episode;
    }

    public void setEpisode(final Episode episode) {
        this.episode = episode;
    }

    */
    public Movie getMovie() {
        return movie;
    }

    public void setMovie(final Movie movie) {
        this.movie = movie;
    }

    public Role getRoleType() {
        return roleType;
    }

    public void setRoleType(final Role roleType) {
        this.roleType = roleType;
    }

    public String getRole() {
        return role;
    }

    public void setRole(final String role) {
        this.role = role;
    }
}
