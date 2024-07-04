package com.amachi.app.film.service.impl;


import com.amachi.app.film.common.exception.FilmException;
import com.amachi.app.film.common.util.ErrorEnum;
import com.amachi.app.film.dto.search.ActeurSearchDto;
import com.amachi.app.film.entities.Acteur;
import com.amachi.app.film.repository.ActeurRepository;
import com.amachi.app.film.service.ActeurService;
import com.amachi.app.film.util.AppConstants;
import com.amachi.app.film.util.AppUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.google.common.base.Preconditions.checkNotNull;

@RequiredArgsConstructor
@Service
public class ActeurServiceImpl implements ActeurService {

    private final ActeurRepository acteurRepository;

    @Override
    public Acteur getActeur(Long idActeur) {
        checkNotNull(idActeur);
        Optional<Acteur> acteurOptional = acteurRepository.findById(idActeur);
        if (acteurOptional.isEmpty()) {
            throw new FilmException(ErrorEnum.OBJECT_NOT_FOUND, idActeur);
        }
        return acteurOptional.get();
    }

    @Override
    public Acteur addActeur(Acteur acteur) {
        checkNotNull(acteur);
        return acteurRepository.save(acteur);
    }

    @Override
    public Acteur updateActeur(Long idActeur, Acteur acteur) {
        checkNotNull(idActeur);

        Optional<Acteur> acteurOptional = acteurRepository.findById(idActeur);
        if (acteurOptional.isEmpty()) {
            throw new FilmException(ErrorEnum.OBJECT_NOT_FOUND, idActeur);
        }
        return acteurRepository.save(acteur);
    }

    @Override
    public void deleteActeur(Long idActeur) {
        checkNotNull(idActeur);
        Optional<Acteur> acteurOptional = acteurRepository.findById(idActeur);
        if (acteurOptional.isEmpty()) {
            return;
        }
        acteurRepository.delete(acteurOptional.get());
    }

    @Override
    public Page<Acteur> getActeurs(ActeurSearchDto acteurSearchDto, Integer pageNumber, Integer pageSize, String sort) {
        checkNotNull(acteurSearchDto);
        var sortById = AppConstants.DEFAULT_SORT_BY + Acteur.class.getSimpleName();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, AppUtils.getSort(sort, sortById));
        return acteurRepository.getActeurs(acteurSearchDto, pageable);
    }

    @Override
    public List<Acteur> findAllActeurs() {
        return acteurRepository.findAll();
    }
}