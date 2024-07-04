package com.amachi.app.film.dto.search;

import io.swagger.v3.oas.annotations.Hidden;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Hidden
public class ActeurSearchDto {
    private String nom;
    private String prenom;
}
