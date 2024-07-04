package com.amachi.app.film.persistance;

import com.amachi.app.film.dto.search.FilmSearchDto;
import com.amachi.app.film.entities.Film;
import com.amachi.app.film.entities.Film_;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class FilmSpecification  implements Specification<Film> {

    private transient FilmSearchDto filmSearchDto;

    @Override
    public Predicate toPredicate(Root<Film> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {

        List<Predicate> predicates = new ArrayList<>();

        if (filmSearchDto.getTitre() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Film_.TITRE), filmSearchDto.getTitre()));
        }
        if (filmSearchDto.getDescription() != null) {
            predicates.add(criteriaBuilder.equal(root.get(Film_.DESCRIPTION), filmSearchDto.getDescription()));
        }

        return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
    }
}
