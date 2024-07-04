package com.amachi.app.film.common.mapper;

import org.mapstruct.MapperConfig;
import org.mapstruct.ReportingPolicy;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Collections.emptyList;
import static java.util.Collections.emptySet;

@MapperConfig(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR, unmappedSourcePolicy = ReportingPolicy.WARN)
public interface EntityDtoMapper<E, D> {
    E toEntity(D dto);

    D toDto(E entity);

    default List<D> toDTOs(Collection<E> entityList) {
        if (entityList == null) {
            return emptyList();
        }
        return entityList.stream().map(this::toDto).collect(Collectors.toList());
    }

    default List<E> ToEntities(Collection<D> modelList) {
        if (modelList == null) {
            return emptyList();
        }
        return modelList.stream().map(this::toEntity).collect(Collectors.toList());
    }

    default Set<E> ToEntitiesSet(Collection<D> modelSet) {
        if (modelSet == null) {
            return emptySet();
        }
        return modelSet.stream().map(this::toEntity).collect(Collectors.toSet());
    }

}
