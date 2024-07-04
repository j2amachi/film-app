package com.amachi.app.film.mapper;

import com.amachi.app.film.common.mapper.EntityDtoMapper;
import com.amachi.app.film.dto.FilmDto;
import com.amachi.app.film.entities.Film;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(config = EntityDtoMapper.class, builder = @Builder(disableBuilder = true))
public interface FilmMapper extends EntityDtoMapper<Film, FilmDto> {

    FilmMapper INSTANCE = Mappers.getMapper(FilmMapper.class);

    @Override
    Film toEntity(FilmDto dto);

    @Override
    FilmDto toDto(Film entity);
}
