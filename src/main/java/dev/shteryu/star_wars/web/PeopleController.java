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
import dev.shteryu.star_wars.mapper.PeopleMapper;
import dev.shteryu.star_wars.models.People;
import dev.shteryu.star_wars.service.PeopleService;
import dev.shteryu.star_wars.validation.ObjectValidator;
import dev.shteryu.star_wars.web.dto.PeopleCreateRequest;
import dev.shteryu.star_wars.web.dto.PeopleResponse;
import dev.shteryu.star_wars.web.dto.PeopleUpdateRequest;
import dev.shteryu.star_wars.web.dto.StarWarsApiPage;


@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private PeopleMapper peopleMapper;

    @Autowired
    private PeopleService peopleService;

    private final Integer PAFE_SIZE = 10;


    @GetMapping(name = "", produces = "application/json")
    public StarWarsApiPage<PeopleResponse> getAllPeople(
        @RequestParam(required = false, defaultValue = "0") Integer currentPage) {
            Page<PeopleResponse> personPage =
            peopleService.fetchAll(currentPage, PAFE_SIZE)
            .map(peopleMapper::responseFromModel);

        return new StarWarsApiPage<>(personPage);
    }

    @GetMapping(value="/{peopleId}")
    public ResponseEntity<PeopleResponse> getPeopleById(@PathVariable String peopleId) {
        People people = peopleService.findById(peopleId);

        return ResponseEntity.ok(peopleMapper.responseFromModel(people));
    }
    
    @PostMapping("")
    public ResponseEntity<PeopleResponse> createPeople(@RequestBody PeopleCreateRequest peopleDto) {

        Map<String, String> validationErrors = validator.validate(peopleDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Person Create", validationErrors);
        }

        People mappedPeople = peopleMapper.modelFromCreateRequest(peopleDto);
        People savedPeople = peopleService.save(mappedPeople);
        PeopleResponse responsePeople = peopleMapper.responseFromModel(savedPeople);

        return ResponseEntity.status(201).body(responsePeople);
    }

    @PatchMapping("/{peopleId}")
    public ResponseEntity<PeopleResponse> updatePeople(@PathVariable String peopleId,
            @RequestBody PeopleUpdateRequest peopleDto) {

        Map<String, String> validationErrors = validator.validate(peopleDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Person Create", validationErrors);
        }

        People currentPeople = peopleService.findById(peopleId);

        peopleMapper.updateModelFromDto(peopleDto, currentPeople);

        People updatedPeople = peopleService.save(currentPeople);

        PeopleResponse responsePeople = peopleMapper.responseFromModel(updatedPeople);

        return ResponseEntity.status(200).body(responsePeople);
    }

    @DeleteMapping("/{personId}")
    public void deletePeopleById(@PathVariable String peopleId) {
        peopleService.deleteById(peopleId);
    }

    
}
