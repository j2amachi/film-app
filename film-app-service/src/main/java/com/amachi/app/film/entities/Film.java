package com.amachi.app.film.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "FILM")
public class Film implements Model {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TITRE", nullable = false, length = 10)
    private String titre;

    @Column(name = "DESCRIPTION", length = 255)
    private String description;

    @ManyToMany
    @JoinTable(
            name = "FILM_ACTEUR",
            joinColumns = @JoinColumn(name = "film_id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id")
    )
    private List<Acteur> acteurs = new ArrayList<>();

}
