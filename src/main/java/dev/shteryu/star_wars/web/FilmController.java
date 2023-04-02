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
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.repository.FilmRepository;


@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private FilmRepository filmRepo;


    @GetMapping("")
    public List<Films> getAllFilms() {
        return (List<Films>) filmRepo.findAll();
    }

    @GetMapping(value="/{filmId}")
    public Optional<Films> getPeopleById(@PathVariable Long filmId) {
        return filmRepo.findById(filmId);
    }
    
    @PostMapping("")
    public ResponseEntity<Films> createFilm(@RequestBody Films film,
            BindingResult bindings) {
        Films newFilm = filmRepo.save(film);
        return ResponseEntity.status(201).body(newFilm);
    }
    
}
