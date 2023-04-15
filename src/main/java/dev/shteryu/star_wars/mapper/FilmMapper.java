package dev.shteryu.star_wars.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.web.dto.FilmCreateRequest;
import dev.shteryu.star_wars.web.dto.FilmResponse;
import dev.shteryu.star_wars.web.dto.FilmUpdateRequest;

@Mapper
public interface FilmMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "planets", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "vehicles", ignore = true)
    @Mapping(target = "species", ignore = true)
    Films modelFromCreateRequest(FilmCreateRequest filmCreateDto);
    
    FilmResponse responseFromModel(Films film);

    @Mapping(target = "characters", ignore = true)
    @Mapping(target = "planets", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "vehicles", ignore = true)
    @Mapping(target = "species", ignore = true)
    @Mapping(target = "title", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "episode_id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "opening_crawl", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "director", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "producer", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "release_date", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(FilmUpdateRequest filmUpdateDto, @MappingTarget Films film);

    List<FilmResponse> listOfModelToListOfDto(Iterable<Films> film);

}
