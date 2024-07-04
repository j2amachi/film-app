package com.amachi.app.film.controller;

import com.amachi.app.film.common.controller.BaseController;
import com.amachi.app.film.common.repository.UiOrderToEntityOrderPropertyMapper;
import com.amachi.app.film.dto.FilmDto;
import com.amachi.app.film.dto.search.FilmSearchDto;
import com.amachi.app.film.entities.Film;
import com.amachi.app.film.mapper.FilmMapper;
import com.amachi.app.film.service.FilmService;
import io.swagger.v3.oas.annotations.Hidden;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@AllArgsConstructor
@Slf4j
public class FilmController extends BaseController<Film> implements FilmApi {

    private FilmService filmService;
    private FilmMapper filmMapper;
    private UiOrderToEntityOrderPropertyMapper uiOrderToEntityOrderPropertyMapper;

    @Override
    public ResponseEntity<FilmDto> getFilm(Long idFilm) {
        final var film = filmService.getFilm(idFilm);
        return new ResponseEntity<>(filmMapper.toDto(film), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<FilmDto> addFilm(FilmDto filmDto) {
        final var film = filmService.addFilm(filmMapper.toEntity(filmDto));
        return new ResponseEntity<>(filmMapper.toDto(film), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<FilmDto> updateFilm(Long idFilm, FilmDto filmDto) {
        var film = filmService.updateFilm(idFilm, filmMapper.toEntity(filmDto));
        return new ResponseEntity<>(filmMapper.toDto(film), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Object> deleteFilm(@PathVariable("id") final Long idFilm) {
        filmService.deleteFilm(idFilm);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Override
    @Hidden
    //	@GetMapping(value = "/films", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Page<FilmDto>> getFilms(FilmSearchDto filmSearchDto, Integer pageNumber, Integer pageSize, String sort) {
        final Page<Film> pageFilm = filmService.getFilms(filmSearchDto, pageNumber, pageSize, sort);
        return new ResponseEntity<>(convert(pageFilm, filmMapper, uiOrderToEntityOrderPropertyMapper), HttpStatus.OK);
    }

    @Override
    //	@GetMapping(value = "/filmsall", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FilmDto>> findAllFilms() {
        log.info("/filmsall request received");
        List<Film> films = filmService.findAllFilms();
        List<FilmDto> filmDtos = films.stream().map(entity -> filmMapper.toDto(entity)).collect(Collectors.toList());
        return ResponseEntity.ok(filmDtos);
    }

    @Override
    protected Class<Film> getEntityClass() {
        return Film.class;
    }
}