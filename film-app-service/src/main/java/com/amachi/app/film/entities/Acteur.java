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
@Table(name = "ACTEUR")
public class Acteur  implements Model {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NOM", length = 50, nullable = false)
    private String nom;

    @Column(name = "PRENOM", length = 50)
    private String prenom;

    @ManyToMany(mappedBy = "acteurs", fetch = FetchType.LAZY)
    private List<Film> films = new ArrayList<>();
}
