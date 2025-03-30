package de.seriestracker.media;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@MappedSuperclass
public abstract class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty
    @Size(max = 256)
    @Column(name = "title")
    private String title;

    @NotEmpty
    @Size(max = 1024)
    @Column(name = "description")
    private String description;

    @Column(name = "premiere_date")
    private LocalDate premiereDate;

    public Media() {}

    public Media(final String title, final String description, final LocalDate premiereDate) {
        this.title = title;
        this.description = description;
        this.premiereDate = premiereDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public LocalDate getPremiereDate() {
        return premiereDate;
    }

    public void setPremiereDate(final LocalDate premiereDate) {
        this.premiereDate = premiereDate;
    }
}
