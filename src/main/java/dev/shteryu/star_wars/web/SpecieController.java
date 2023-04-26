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
import dev.shteryu.star_wars.mapper.SpecieMapper;
import dev.shteryu.star_wars.models.Species;
import dev.shteryu.star_wars.service.SpecieService;
import dev.shteryu.star_wars.validation.ObjectValidator;
import dev.shteryu.star_wars.web.dto.SpecieCreateRequest;
import dev.shteryu.star_wars.web.dto.SpecieResponse;
import dev.shteryu.star_wars.web.dto.SpecieUpdateRequest;
import dev.shteryu.star_wars.web.dto.StarWarsApiPage;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/species")
public class SpecieController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private SpecieMapper specieMapper;

    @Autowired
    private SpecieService specieService;

    private final Integer PAFE_SIZE = 10;


    @GetMapping(name = "", produces = "application/json")
    public StarWarsApiPage<SpecieResponse> getAllSpecie(
        @RequestParam(required = false, defaultValue = "0") Integer currentPage) {
            Page<SpecieResponse> speciePage =
            specieService.fetchAll(currentPage, PAFE_SIZE)
            .map(specieMapper::responseFromModel);

        return new StarWarsApiPage<>(speciePage);
    }

    @GetMapping(value="/{specieId}")
    public ResponseEntity<SpecieResponse> getSpecieById(@PathVariable String specieId) {
        Species specie = specieService.findById(specieId);

        return ResponseEntity.ok(specieMapper.responseFromModel(specie));
    }
    
    @PostMapping("")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public ResponseEntity<SpecieResponse> createSpecie(@RequestBody SpecieCreateRequest specieDto) {

        Map<String, String> validationErrors = validator.validate(specieDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Specie Create", validationErrors);
        }

        Species mappedSpecie = specieMapper.modelFromCreateRequest(specieDto);
        Species savedSpecie = specieService.save(mappedSpecie);
        SpecieResponse responseSpecie = specieMapper.responseFromModel(savedSpecie);

        return ResponseEntity.status(201).body(responseSpecie);
    }

    @PatchMapping("/{specieId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public ResponseEntity<SpecieResponse> updateSpecie(@PathVariable String specieId,
            @RequestBody SpecieUpdateRequest specieDto) {

        Map<String, String> validationErrors = validator.validate(specieDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Specie Create", validationErrors);
        }

        Species currentSpecie = specieService.findById(specieId);

        specieMapper.updateModelFromDto(specieDto, currentSpecie);

        Species updatedSpecie = specieService.save(currentSpecie);

        SpecieResponse responseSpecie = specieMapper.responseFromModel(updatedSpecie);

        return ResponseEntity.status(200).body(responseSpecie);
    }

    @DeleteMapping("/{specieId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public void deleteSpecieById(@PathVariable String specieId) {
        specieService.deleteById(specieId);
    }
    
}
