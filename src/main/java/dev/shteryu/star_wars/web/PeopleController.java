package dev.shteryu.star_wars.web;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.shteryu.star_wars.models.People;
import dev.shteryu.star_wars.repository.PeopleRepository;


@RestController
@RequestMapping("/people")
public class PeopleController {

    @Autowired
    private PeopleRepository peopleRepo;


    @GetMapping("")
    public List<People> getAllPeople() {
        return (List<People>) peopleRepo.findAll();
    }

    @GetMapping(value="/{peopleId}")
    public Optional<People> getPeopleById(@PathVariable Long peopleId) {
        return peopleRepo.findById(peopleId);
    }
    
    @PostMapping("")
    public ResponseEntity<People> createPeople(@RequestBody People people,
            BindingResult bindings) {
        People newPeople = peopleRepo.save(people);
        return ResponseEntity.status(201).body(newPeople);
    }
    
}
