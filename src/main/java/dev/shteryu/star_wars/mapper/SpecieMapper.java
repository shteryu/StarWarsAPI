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

    @Mapping(target = "speciePeople", ignore = true)
    @Mapping(target = "specieFilms", ignore = true)
    @Mapping(target = "id", ignore = true)
    Species modelFromCreateRequest(SpecieCreateRequest SpecieCreateDto);
    
    SpecieResponse responseFromModel(Species specie);

    @Mapping(target = "speciePeople", ignore = true)
    @Mapping(target = "specieFilms", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "classification", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "designation", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "averageHeight", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "skinColors", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "hairColors", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "eyeColors", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "averageLifespan", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "homeworld", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "language", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(SpecieUpdateRequest specieUpdateDto, @MappingTarget Species specie);

    List<SpecieResponse> listOfModelToListOfDto(Iterable<Species> specie);

}
