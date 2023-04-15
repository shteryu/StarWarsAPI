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
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "species", ignore = true)
    @Mapping(target = "vehicles", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "url", ignore = true)
    People modelFromCreateRequest(PeopleCreateRequest peopleCreateDto);
    
    PeopleResponse responseFromModel(People people);

    @Mapping(target = "films", ignore = true)
    @Mapping(target = "species", ignore = true)
    @Mapping(target = "vehicles", ignore = true)
    @Mapping(target = "starships", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "height", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "mass", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "hair_color", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "skin_color", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "eye_color", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "birth_year", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "gender", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "homeworld", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(PeopleUpdateRequest peopleUpdateDto, @MappingTarget People people);

    List<PeopleResponse> listOfModelToListOfDto(Iterable<People> people);
}
