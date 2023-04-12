package dev.shteryu.star_wars.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import dev.shteryu.star_wars.models.Planets;
import dev.shteryu.star_wars.web.dto.PlanetsCreateRequest;
import dev.shteryu.star_wars.web.dto.PlanetsDto;
import dev.shteryu.star_wars.web.dto.PlanetsResponse;
import dev.shteryu.star_wars.web.dto.PlanetsUpdateRequest;

@Mapper
public interface PlanetsMapper {

    PlanetsDto modelToDto(Planets planets);
    Planets dtoToModel(PlanetsDto planetsDto);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "url", ignore = true)
    Planets modelFromCreateRequest(PlanetsCreateRequest planetsCreateDto);
    
    PlanetsResponse responseFromModel(Planets planets);

    @Mapping(target = "films", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "rotation_period", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "orbital_period", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "diameter", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "climate", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "gravity", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "terrain", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "surface_water", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "population", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "url", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(PlanetsUpdateRequest planetsUpdateDto, @MappingTarget Planets planets);

    List<PlanetsResponse> listOfModelToListOfDto(Iterable<Planets> planets);   

}
