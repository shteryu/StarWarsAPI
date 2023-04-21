package dev.shteryu.star_wars.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import dev.shteryu.star_wars.models.Planets;
import dev.shteryu.star_wars.web.dto.PlanetCreateRequest;
import dev.shteryu.star_wars.web.dto.PlanetResponse;
import dev.shteryu.star_wars.web.dto.PlanetUpdateRequest;

@Mapper
public interface PlanetMapper {

    @Mapping(target = "planetPeople", ignore = true)
    @Mapping(target = "planetFilms", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "url", ignore = true)
    Planets modelFromCreateRequest(PlanetCreateRequest planetsCreateDto);
    
    PlanetResponse responseFromModel(Planets planets);

    @Mapping(target = "planetPeople", ignore = true)
    @Mapping(target = "planetFilms", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "rotationPeriod", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "orbitalPeriod", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "diameter", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "climate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "gravity", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "terrain", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "surfaceWater", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "population", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "url", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(PlanetUpdateRequest planetsUpdateDto, @MappingTarget Planets planets);

    List<PlanetResponse> listOfModelToListOfDto(Iterable<Planets> planets);   

}
