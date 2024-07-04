package com.amachi.app.film.controller;

import com.amachi.app.film.dto.ActeurDto;
import com.amachi.app.film.dto.search.ActeurSearchDto;
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

@Tag(name = "Acteur", description = "Rest API Film APP to CREATE, UPDATE, FETCH and DELETE Acteur details")
public interface ActeurApi {
    @Operation(
            summary = "Retrieve a Acteur by Id",
            method = "getActeur",
            description = "Get a Acteur object by specifying id. The response is Acteur object with id",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of Acteurs returned successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @GetMapping(value = "/acteurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ActeurDto> getActeur(@Parameter(required = true) @PathVariable("id") Integer idActeur);

    @Operation(
            summary = "Create a Acteur",
            description = "Acteur Object send as body parameters",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Acteur created successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @PostMapping(value = "/acteurs", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ActeurDto> addActeur(@Parameter(description = "Create a Acteur", required = true) @Valid @RequestBody ActeurDto acteurDTO);

    @Operation(
            summary = "Modify Acteur",
            method = "updateActeur",
            description = "Modify Acteur by ID and Acteur Object send as body parameters",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Acteur modified successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @PutMapping(value = "/acteurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<ActeurDto> updateActeur(@Parameter(description = "Update Acteur", required = true) @PathVariable("id") Integer idActeur, @Valid @RequestBody ActeurDto acteurDTO);

    @Operation(
            summary = "Delete Acteur",
            method = "deleteActeur",
            description = "Delete an Acteur by ID",
            responses = {
                    @ApiResponse(responseCode = "200", description = "Delete Acteur successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @DeleteMapping(value = "/acteurs/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Object> deleteActeur(@Parameter(description = "Delete objet Acteur", required = true) @PathVariable("id") Integer idActeur);

    @Operation(
            summary = "Retrieve all Acteurs",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of Acteurs returned successfully"),
                    @ApiResponse(responseCode = "204", description = "There are no Acteur"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @GetMapping(value = "/acteurs", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<Page<ActeurDto>> getActeurs(ActeurSearchDto acteurSearchDTO,
                                               @RequestParam(value = "pageNumber", defaultValue = "10", required = false) final Integer pageNumber,
                                               @RequestParam(value = "pageSize", defaultValue = "1", required = false) final Integer pageSize,
                                               @RequestParam(value = "sort", defaultValue = "idActeur", required = false) final String sort);

    @Operation(
            summary = "Returns the list of Acteurs",
            method = "findAllActeurs",
            description = "Returns the list of Acteurs",
            responses = {
                    @ApiResponse(responseCode = "200", description = "List of Acteurs returned successfully"),
                    @ApiResponse(responseCode = "401", description = "Unauthorized"),
                    @ApiResponse(responseCode = "403", description = "Access denied"),
                    @ApiResponse(responseCode = "404", description = "Page not found"),
                    @ApiResponse(responseCode = "405", description = "Invalid entry"),
                    @ApiResponse(responseCode = "500", description = "The server did not respond")
            })
    @GetMapping(value = "/acteursall", produces = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<List<ActeurDto>> findAllActeurs();
}
