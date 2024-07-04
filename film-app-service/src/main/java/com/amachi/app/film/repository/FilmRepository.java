package com.amachi.app.film.repository;

import com.amachi.app.film.dto.search.FilmSearchDto;
import com.amachi.app.film.entities.Film;
import com.amachi.app.film.persistance.FilmSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface FilmRepository extends JpaRepository<Film, Long>, JpaSpecificationExecutor<Film> {
    default Page<Film> getFilms(FilmSearchDto filmSearchDto, Pageable pageable) {
        return findAll(new FilmSpecification(filmSearchDto), pageable);
    }

    Page<Film> findByTitreLike(String titre, Pageable pageable);
}
