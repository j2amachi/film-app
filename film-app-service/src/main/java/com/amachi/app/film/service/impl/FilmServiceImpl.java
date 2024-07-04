package com.amachi.app.film.service.impl;

import com.amachi.app.film.common.exception.FilmException;
import com.amachi.app.film.common.util.ErrorEnum;
import com.amachi.app.film.dto.search.FilmSearchDto;
import com.amachi.app.film.entities.Film;
import com.amachi.app.film.repository.FilmRepository;
import com.amachi.app.film.service.FilmService;
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
public class FilmServiceImpl implements FilmService {

    private final FilmRepository filmRepository;

    @Override
    public Film getFilm(Long idFilm) {
        checkNotNull(idFilm);
        Optional<Film> filmOptional = filmRepository.findById(idFilm);
        if (filmOptional.isEmpty()) {
            throw new FilmException(ErrorEnum.OBJECT_NOT_FOUND, idFilm);
        }
        return filmOptional.get();
    }

    @Override
    public Film addFilm(Film film) {
        checkNotNull(film);
        return filmRepository.save(film);
    }

    @Override
    public Film updateFilm(Long idFilm, Film film) {
        checkNotNull(idFilm);

        Optional<Film> filmOptional = filmRepository.findById(idFilm);
        if (filmOptional.isEmpty()) {
            throw new FilmException(ErrorEnum.OBJECT_NOT_FOUND, idFilm);
        }
        return filmRepository.save(film);
    }

    @Override
    public void deleteFilm(Long idFilm) {
        checkNotNull(idFilm);
        Optional<Film> filmOptional = filmRepository.findById(idFilm);
        if (filmOptional.isEmpty()) {
            return;
        }
        filmRepository.delete(filmOptional.get());
    }

    @Override
    public Page<Film> getFilms(FilmSearchDto filmSearchDto, Integer pageNumber, Integer pageSize, String sort) {
        checkNotNull(filmSearchDto);
        var sortById = AppConstants.DEFAULT_SORT_BY + Film.class.getSimpleName();
        Pageable pageable = PageRequest.of(pageNumber, pageSize, AppUtils.getSort(sort, sortById));
        return filmRepository.getFilms(filmSearchDto, pageable);
    }

    @Override
    public List<Film> findAllFilms() {
        return filmRepository.findAll();
    }
}
