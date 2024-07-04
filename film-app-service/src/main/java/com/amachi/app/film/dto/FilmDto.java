package com.amachi.app.film.dto;

import com.amachi.app.film.entities.Acteur;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
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
@Schema(name = "Film", description = "Schéma contenant les informations du film")
public class FilmDto {
    @JsonProperty
    @Schema(
            description = "Id du film", hidden = true
    )
    private Long id;

    @JsonProperty
    @Schema(
            description = "Titre du film", example = "Terminator"
    )
    private String titre;

    @JsonProperty
    @Schema(
            description = "Description du film", example = "Film de science fiction"
    )
    private String description;

    @JsonProperty
    @Schema(
            description = "Liste des acteurs qui ont le film"
    )
    private Set<ActeurDto> acteurs;
}
