package dev.shteryu.star_wars.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import dev.shteryu.star_wars.models.People;
import dev.shteryu.star_wars.web.dto.PeopleCreateRequest;
import dev.shteryu.star_wars.web.dto.PeopleResponse;
import dev.shteryu.star_wars.web.dto.PeopleUpdateRequest;

@Mapper
public interface PeopleMapper {
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "peopleFilms", ignore = true)
    @Mapping(target = "peopleSpecies", ignore = true)
    @Mapping(target = "peopleVehicles", ignore = true)
    @Mapping(target = "peopleStarships", ignore = true)
    @Mapping(target = "url", ignore = true)
    People modelFromCreateRequest(PeopleCreateRequest peopleCreateDto);
    
    PeopleResponse responseFromModel(People people);

    @Mapping(target = "peopleFilms", ignore = true)
    @Mapping(target = "peopleSpecies", ignore = true)
    @Mapping(target = "peopleVehicles", ignore = true)
    @Mapping(target = "peopleStarships", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "height", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "mass", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "hairColor", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "skinColor", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "eyeColor", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "birthYear", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "gender", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(PeopleUpdateRequest peopleUpdateDto, @MappingTarget People people);

    List<PeopleResponse> listOfModelToListOfDto(Iterable<People> people);
}
