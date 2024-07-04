package com.amachi.app.film.repository;

import com.amachi.app.film.dto.search.ActeurSearchDto;
import com.amachi.app.film.entities.Acteur;
import com.amachi.app.film.persistance.ActeurSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ActeurRepository extends JpaRepository<Acteur, Long>, JpaSpecificationExecutor<Acteur> {
    default Page<Acteur> getActeurs(ActeurSearchDto acteurSearchDto, Pageable pageable) {
        return findAll(new ActeurSpecification(acteurSearchDto), pageable);
    }

    Page<Acteur> findByTitreLike(String titre, Pageable pageable);
}