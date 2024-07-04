package com.amachi.app.film.mapper;

import com.amachi.app.film.common.mapper.EntityDtoMapper;
import com.amachi.app.film.dto.ActeurDto;
import com.amachi.app.film.entities.Acteur;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = EntityDtoMapper.class, builder = @Builder(disableBuilder = true))
public interface ActeurMapper extends EntityDtoMapper<Acteur, ActeurDto> {
    ActeurMapper INSTANCE = Mappers.getMapper(ActeurMapper.class);

    @Override
    Acteur toEntity(ActeurDto dto);

    @Override
    ActeurDto toDto(Acteur entity);
}