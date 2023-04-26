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
import dev.shteryu.star_wars.mapper.StarshipMapper;
import dev.shteryu.star_wars.models.Starships;
import dev.shteryu.star_wars.service.StarshipService;
import dev.shteryu.star_wars.validation.ObjectValidator;
import dev.shteryu.star_wars.web.dto.StarWarsApiPage;
import dev.shteryu.star_wars.web.dto.StarshipCreateRequest;
import dev.shteryu.star_wars.web.dto.StarshipResponse;
import dev.shteryu.star_wars.web.dto.StarshipUpdateRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


@RestController
@RequestMapping("/starships")
public class StarshipController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private StarshipMapper starshipMapper;

    @Autowired
    private StarshipService starshipService;

    private final Integer PAFE_SIZE = 10;


    @GetMapping(name = "", produces = "application/json")
    public StarWarsApiPage<StarshipResponse> getAllStarship(
        @RequestParam(required = false, defaultValue = "0") Integer currentPage) {
            Page<StarshipResponse> starshipPage =
            starshipService.fetchAll(currentPage, PAFE_SIZE)
            .map(starshipMapper::responseFromModel);

        return new StarWarsApiPage<>(starshipPage);
    }

    @GetMapping(value="/{starshipId}")
    public ResponseEntity<StarshipResponse> getStarshipById(@PathVariable String starshipId) {
        Starships starship = starshipService.findById(starshipId);

        return ResponseEntity.ok(starshipMapper.responseFromModel(starship));
    }
    
    @PostMapping("")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public ResponseEntity<StarshipResponse> createStarship(@RequestBody StarshipCreateRequest starshipDto) {

        Map<String, String> validationErrors = validator.validate(starshipDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Starship Create", validationErrors);
        }

        Starships mappedStarship = starshipMapper.modelFromCreateRequest(starshipDto);
        Starships savedStarship = starshipService.save(mappedStarship);
        StarshipResponse responseStarship = starshipMapper.responseFromModel(savedStarship);

        return ResponseEntity.status(201).body(responseStarship);
    }

    @PatchMapping("/{starshipId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public ResponseEntity<StarshipResponse> updateStarship(@PathVariable String starshipId,
            @RequestBody StarshipUpdateRequest starshipDto) {

        Map<String, String> validationErrors = validator.validate(starshipDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Starship Create", validationErrors);
        }

        Starships currentStarship = starshipService.findById(starshipId);

        starshipMapper.updateModelFromDto(starshipDto, currentStarship);

        Starships updatedStarship = starshipService.save(currentStarship);

        StarshipResponse responseStarship = starshipMapper.responseFromModel(updatedStarship);

        return ResponseEntity.status(200).body(responseStarship);
    }

    @DeleteMapping("/{starshipId}")
    @Operation(security = { @SecurityRequirement(name = "bearer-key") })
    public void deleteStarshipById(@PathVariable String starshipId) {
        starshipService.deleteById(starshipId);
    }

    
}
