package de.seriestracker.media;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@MappedSuperclass
public abstract class Media {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "premiere_date")
    private Date premiereDate;

}
