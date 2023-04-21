package dev.shteryu.star_wars.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import dev.shteryu.star_wars.models.Starships;
import dev.shteryu.star_wars.web.dto.StarshipCreateRequest;
import dev.shteryu.star_wars.web.dto.StarshipResponse;
import dev.shteryu.star_wars.web.dto.StarshipUpdateRequest;

@Mapper
public interface StarshipMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "starshipPeople", ignore = true)
    @Mapping(target = "starshipFilms", ignore = true)
    Starships modelFromCreateRequest(StarshipCreateRequest StarshipCreateDto);
    
    StarshipResponse responseFromModel(Starships starship);

    @Mapping(target = "starshipPeople", ignore = true)
    @Mapping(target = "starshipFilms", ignore = true)
    @Mapping(target = "name", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "model", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "manufacturer", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "costInCredits", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "length", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "maxAtmospheringSpeed", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "crew", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "passengers", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "cargoCapacity", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "consumables", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "vehicleClass", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "url", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateModelFromDto(StarshipUpdateRequest starshipUpdateDto, @MappingTarget Starships starship);

    List<StarshipResponse> listOfModelToListOfDto(Iterable<Starships> starship);

}
