package dev.shteryu.star_wars.mapper;

import org.mapstruct.Mapper;
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.web.dto.FilmsDto;

@Mapper
public interface FilmMapper {

    FilmsDto modelToDto(Films films);
    Films dtoToModel(FilmsDto FilmsDto);

}
