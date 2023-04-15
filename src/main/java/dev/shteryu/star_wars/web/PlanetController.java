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
import dev.shteryu.star_wars.mapper.PlanetMapper;
import dev.shteryu.star_wars.models.Planets;
import dev.shteryu.star_wars.service.PlanetService;
import dev.shteryu.star_wars.validation.ObjectValidator;
import dev.shteryu.star_wars.web.dto.PlanetCreateRequest;
import dev.shteryu.star_wars.web.dto.PlanetResponse;
import dev.shteryu.star_wars.web.dto.PlanetUpdateRequest;
import dev.shteryu.star_wars.web.dto.StarWarsApiPage;


@RestController
@RequestMapping("/planets")
public class PlanetController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private PlanetService planetService;

    @Autowired
    private PlanetMapper planetsMapper;

    private final Integer PAFE_SIZE = 10;


    @GetMapping(name = "", produces = "application/json")
    public StarWarsApiPage<PlanetResponse> getAllPlanets(
        @RequestParam(required = false, defaultValue = "0") Integer currentPage) {
            Page<PlanetResponse> planetPage =
            planetService.fetchAll(currentPage, PAFE_SIZE)
            .map(planetsMapper::responseFromModel);

        return new StarWarsApiPage<>(planetPage);
    }

    @GetMapping(value="/{planetId}")
    public ResponseEntity<PlanetResponse> getPlanetById(@PathVariable String planetId) {
        Planets planet = planetService.findById(planetId);

        return ResponseEntity.ok(planetsMapper.responseFromModel(planet));
    }
    
    @PostMapping("")
    public ResponseEntity<PlanetResponse> createPlanet(@RequestBody PlanetCreateRequest planetDto) {

        Map<String, String> validationErrors = validator.validate(planetDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Planet Create", validationErrors);
        }

        Planets mappedPlanet = planetsMapper.modelFromCreateRequest(planetDto);
        Planets savedPlanet = planetService.save(mappedPlanet);
        PlanetResponse responsePlanet = planetsMapper.responseFromModel(savedPlanet);

        return ResponseEntity.status(201).body(responsePlanet);
    }

    @PatchMapping("/{planetId}")
    public ResponseEntity<PlanetResponse> updatePlanet(@PathVariable String planetId,
            @RequestBody PlanetUpdateRequest planetDto) {

        Map<String, String> validationErrors = validator.validate(planetDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Planet Create", validationErrors);
        }

        Planets currentPlanet = planetService.findById(planetId);

        planetsMapper.updateModelFromDto(planetDto, currentPlanet);

        Planets updatedPlanet = planetService.save(currentPlanet);

        PlanetResponse responsePlanet = planetsMapper.responseFromModel(updatedPlanet);

        return ResponseEntity.status(200).body(responsePlanet);
    }

    @DeleteMapping("/{planetId}")
    public void deletePlanetById(@PathVariable String planetId) {
        planetService.deleteById(planetId);
    }

    
}
