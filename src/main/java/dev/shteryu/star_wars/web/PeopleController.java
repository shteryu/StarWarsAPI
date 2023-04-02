package dev.shteryu.star_wars.web;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import dev.shteryu.star_wars.models.People;
import dev.shteryu.star_wars.repository.PeopleRepository;
import jakarta.persistence.GeneratedValue;


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
    public People getPeopleById(@PathVariable GeneratedValue peopleId) {
        return peopleRepo.findById(peopleId).get();
    }
    
    
}
