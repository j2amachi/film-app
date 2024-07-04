package com.amachi.app.film.controller;

import com.amachi.app.film.dto.FilmDto;
import com.amachi.app.film.dto.search.FilmSearchDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Film", description = "Rest API FILM APP to CREATE, UPDATE, FETCH and DELETE film details")
public interface FilmApi {
    @Operation(
            summary = "Retrieve a Film by Id",
            method = "getFilm",
            description = "Get a Film object by specifying id. The response is Film object with id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of Films returned successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @GetMapping(value = "/films/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FilmDto> getFilm(@Parameter(required = true) @PathVariable("id") Integer idFilm);

    @Operation(
            summary = "Create a Film",
            description = "Film Object send as body parameters",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Film created successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @PostMapping(value = "/films", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FilmDto> addFilm(@Parameter(description = "Create a Film", required = true) @Valid @RequestBody FilmDto filmDTO);

    @Operation(
            summary = "Modify Film",
            method = "updateFilm",
            description = "Modify Film by ID and Film Object send as body parameters",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Film modified successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @PutMapping(value = "/films/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<FilmDto> updateFilm(@Parameter(description = "Update Film", required = true) @PathVariable("id") Integer idFilm, @Valid @RequestBody FilmDto filmDTO);

    @Operation(
            summary = "Delete Film",
            method = "deleteFilm",
            description = "Delete an Film by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Delete Film successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @DeleteMapping(value = "/films/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> deleteFilm(@Parameter(description = "Delete objet Film", required = true) @PathVariable("id") Integer idFilm);

    @Operation(
            summary = "Retrieve all Films",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of Films returned successfully"),
                    @ApiResponse(responseCode = "204", description = "There are no Film"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @GetMapping(value = "/films", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Page<FilmDto>> getFilms(FilmSearchDto filmSearchDTO,
                                           @RequestParam(value = "pageNumber", defaultValue = "10", required = false) final Integer pageNumber,
                                           @RequestParam(value = "pageSize", defaultValue = "1", required = false) final Integer pageSize,
                                           @RequestParam(value = "sort", defaultValue = "idFilm", required = false) final String sort);

    @Operation(
            summary = "Returns the list of Films",
            method = "findAllFilms",
            description = "Returns the list of Films",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of Films returned successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @GetMapping(value = "/filmsall", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<FilmDto>> findAllFilms();
}
