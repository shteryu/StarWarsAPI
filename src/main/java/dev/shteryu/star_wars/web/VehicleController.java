package dev.shteryu.star_wars.web;

import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.shteryu.star_wars.errors.InvalidObjectException;
import dev.shteryu.star_wars.mapper.VehicleMapper;
import dev.shteryu.star_wars.models.Vehicles;
import dev.shteryu.star_wars.service.VehicleService;
import dev.shteryu.star_wars.validation.ObjectValidator;
import dev.shteryu.star_wars.web.dto.StarWarsApiPage;
import dev.shteryu.star_wars.web.dto.VehicleCreateRequest;
import dev.shteryu.star_wars.web.dto.VehicleResponse;
import dev.shteryu.star_wars.web.dto.VehicleUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private VehicleMapper vehicleMapper;

    @Autowired
    private VehicleService vehicleService;

    private final Integer PAFE_SIZE = 10;


    @GetMapping(name = "", produces = "application/json")
    public StarWarsApiPage<VehicleResponse> getAllVehicle(
        @RequestParam(required = false, defaultValue = "0") Integer currentPage) {
            Page<VehicleResponse> vehiclePage =
            vehicleService.fetchAll(currentPage, PAFE_SIZE)
            .map(vehicleMapper::responseFromModel);

        return new StarWarsApiPage<>(vehiclePage);
    }

    @GetMapping(value="/{vehicleId}")
    public ResponseEntity<VehicleResponse> getVehicleById(@PathVariable String vehicleId) {
        Vehicles vehicle = vehicleService.findById(vehicleId);

        return ResponseEntity.ok(vehicleMapper.responseFromModel(vehicle));
    }
    
    @PostMapping("")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public ResponseEntity<VehicleResponse> createVehicle(@RequestBody VehicleCreateRequest vehicleDto) {

        Map<String, String> validationErrors = validator.validate(vehicleDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Vehicle Create", validationErrors);
        }

        Vehicles mappedVehicle = vehicleMapper.modelFromCreateRequest(vehicleDto);
        Vehicles savedVehicle = vehicleService.save(mappedVehicle);
        VehicleResponse responseVehicle = vehicleMapper.responseFromModel(savedVehicle);

        return ResponseEntity.status(201).body(responseVehicle);
    }

    @PatchMapping("/{vehicleId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public ResponseEntity<VehicleResponse> updateVehicle(@PathVariable String vehicleId,
            @RequestBody VehicleUpdateRequest vehicleDto) {

        Map<String, String> validationErrors = validator.validate(vehicleDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Vehicle Create", validationErrors);
        }

        Vehicles currentVehicle = vehicleService.findById(vehicleId);

        vehicleMapper.updateModelFromDto(vehicleDto, currentVehicle);

        Vehicles updatedVehicle = vehicleService.save(currentVehicle);

        VehicleResponse responseVehicle = vehicleMapper.responseFromModel(updatedVehicle);

        return ResponseEntity.status(200).body(responseVehicle);
    }

    @DeleteMapping("/{vehicleId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public void deleteVehicleById(@PathVariable String vehicleId) {
        vehicleService.deleteById(vehicleId);
    }
    
}
