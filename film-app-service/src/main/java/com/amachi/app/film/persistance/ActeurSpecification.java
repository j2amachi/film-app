package com.amachi.app.film.persistance;

import com.amachi.app.film.dto.search.ActeurSearchDto;
import com.amachi.app.film.entities.Acteur;
import com.amachi.app.film.entities.Acteur_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class ActeurSpecification  implements Specification<Acteur> {
    private transient ActeurSearchDto filmSearchDto;

    @Override
    public Predicate toPredicate(Root<Acteur> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (filmSearchDto.getNom() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Acteur_.NOM), filmSearchDto.getNom()));
        }
        if (filmSearchDto.getPrenom() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Acteur_.PRENOM), filmSearchDto.getPrenom()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}