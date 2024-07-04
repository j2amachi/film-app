package com.amachi.app.film.service;

import com.amachi.app.film.dto.search.FilmSearchDto;
import com.amachi.app.film.entities.Film;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FilmService {

    Film getFilm(final Long idFilm);

    Film addFilm(final Film film);

    Film updateFilm(final Long idFilm, final Film film);

    void deleteFilm(final Long idFilm);

    Page<Film> getFilms(final FilmSearchDto filmSearchDto, final Integer pageNumber, final Integer pageSize, final String sort);

    List<Film> findAllFilms();
}
