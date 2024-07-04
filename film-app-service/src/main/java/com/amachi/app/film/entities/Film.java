package com.amachi.app.film.entities;

import jakarta.persistence.*;
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

    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinTable(
            name = "FILM_ACTEUR",
            joinColumns = @JoinColumn(name = "film_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "acteur_id", referencedColumnName = "id")
    )
    private List<Acteur> acteurs = new ArrayList<>();

}
