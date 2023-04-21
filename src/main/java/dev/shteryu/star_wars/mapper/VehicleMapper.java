package dev.shteryu.star_wars.mapper;

import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;
import dev.shteryu.star_wars.models.Vehicles;
import dev.shteryu.star_wars.web.dto.VehicleCreateRequest;
import dev.shteryu.star_wars.web.dto.VehicleResponse;
import dev.shteryu.star_wars.web.dto.VehicleUpdateRequest;

@Mapper
public interface VehicleMapper {

    @Mapping(target = "vehiclePeople", ignore = true)
    @Mapping(target = "vehicleFilms", ignore = true)
    @Mapping(target = "id", ignore = true)
    Vehicles modelFromCreateRequest(VehicleCreateRequest VehicleCreateDto);
    
    VehicleResponse responseFromModel(Vehicles vehicle);

    @Mapping(target = "vehiclePeople", ignore = true)
    @Mapping(target = "vehicleFilms", ignore = true)
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
    void updateModelFromDto(VehicleUpdateRequest vehicleUpdateDto, @MappingTarget Vehicles vehicle);

    List<VehicleResponse> listOfModelToListOfDto(Iterable<Vehicles> vehicle);

}
