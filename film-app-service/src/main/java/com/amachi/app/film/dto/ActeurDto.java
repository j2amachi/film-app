package com.amachi.app.film.dto;

import com.amachi.app.film.entities.Film;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Validated
@Data
@Builder(toBuilder = true)
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "Acteur", description = "Schéma contenant les informations du acteur")

public class ActeurDto {

    @Schema(
            description = "Id du acteur", hidden = true
    )
    private Long id;

    @Schema(
            description = "Nom du acteur", example = "Schwarzenegger"
    )
    private String nom;

    @Schema(
            description = "Prenom du acteur", example = "Arnold"
    )
    private String prenom;


    @Schema(
            description = "Liste des films où participe l'acteur "
    )
    private Set<FilmDto> films;
}
