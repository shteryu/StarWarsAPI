package dev.shteryu.star_wars.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import dev.shteryu.star_wars.models.Species;
import dev.shteryu.star_wars.web.dto.SpecieCreateRequest;
import dev.shteryu.star_wars.web.dto.SpecieResponse;
import dev.shteryu.star_wars.web.dto.SpecieUpdateRequest;

@Mapper
public interface SpecieMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "people", ignore = true)
    @Mapping(target = "films", ignore = true)
    Species modelFromCreateRequest(SpecieCreateRequest SpecieCreateDto);
    
    SpecieResponse responseFromModel(Species specie);

    @Mapping(target = "people", ignore = true)
    @Mapping(target = "films", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "classification", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "designation", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "average_height", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "skin_colors", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "hair_colors", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "eye_colors", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "average_lifespan", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "homeworld", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "language", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(SpecieUpdateRequest specieUpdateDto, @MappingTarget Species specie);

    List<SpecieResponse> listOfModelToListOfDto(Iterable<Species> specie);

}
