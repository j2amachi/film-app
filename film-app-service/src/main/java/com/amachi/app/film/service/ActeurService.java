package com.amachi.app.film.service;

import com.amachi.app.film.dto.search.ActeurSearchDto;
import com.amachi.app.film.entities.Acteur;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActeurService {
    Acteur getActeur(final Long idActeur);

    Acteur addActeur(final Acteur acteur);

    Acteur updateActeur(final Long idActeur, final Acteur acteur);

    void deleteActeur(final Long idActeur);

    Page<Acteur> getActeurs(final ActeurSearchDto acteurSearchDto, final Integer pageNumber, final Integer pageSize, final String sort);

    List<Acteur> findAllActeurs();
    
}
