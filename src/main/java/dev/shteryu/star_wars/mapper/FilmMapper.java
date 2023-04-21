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
    @Mapping(target = "filmPeople", ignore = true)
    @Mapping(target = "filmPlanets", ignore = true)
    @Mapping(target = "filmStarships", ignore = true)
    @Mapping(target = "filmVehicles", ignore = true)
    @Mapping(target = "filmSpecies", ignore = true)
    Films modelFromCreateRequest(FilmCreateRequest filmCreateDto);
    
    FilmResponse responseFromModel(Films film);

    @Mapping(target = "filmPeople", ignore = true)
    @Mapping(target = "filmPlanets", ignore = true)
    @Mapping(target = "filmStarships", ignore = true)
    @Mapping(target = "filmVehicles", ignore = true)
    @Mapping(target = "filmSpecies", ignore = true)
    @Mapping(target = "title", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "episodeId", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "openingCrawl", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "director", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "producer", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "releaseDate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(FilmUpdateRequest filmUpdateDto, @MappingTarget Films film);

    List<FilmResponse> listOfModelToListOfDto(Iterable<Films> film);

}
