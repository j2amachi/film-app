package com.amachi.app.film.common.controller;

import com.amachi.app.film.common.mapper.EntityDtoMapper;
import com.amachi.app.film.common.repository.UiOrderToEntityOrderPropertyMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@RequestMapping("/api/")

public abstract class BaseController<T> {

    protected abstract Class<T> getEntityClass();

    protected <E, D> Set<E> toEntities(Set<D> dtos, EntityDtoMapper<E, D> mapper) {
        return dtos.stream()
                .map(mapper::toEntity)
                .collect(Collectors.toSet());
    }

    protected <E, D> Set<D> toDtos(Set<E> entities, EntityDtoMapper<E, D> mapper) {
        return entities.stream().map(mapper::toDto).collect(Collectors.toSet());
    }

    protected <E, D> Page<D> convert(Page<E> entities, EntityDtoMapper<E, D> mapper, UiOrderToEntityOrderPropertyMapper uiOrderToEntityOrderPropertymapper) {
        return new PageImpl<>(
                entities.get().map(mapper::toDto).collect(Collectors.toList()),
                uiOrderToEntityOrderPropertymapper.convertToDtoPage(entities.getPageable()),
                entities.getTotalPages());
    }

    protected <E, D> List<D> toDtos(List<E> entities, EntityDtoMapper<E, D> mapper) {
        return entities.stream().map(mapper::toDto).collect(Collectors.toList());
    }
}
