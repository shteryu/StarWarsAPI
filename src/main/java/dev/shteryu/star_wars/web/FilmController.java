package dev.shteryu.star_wars.web;

import java.util.Map;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import dev.shteryu.star_wars.errors.InvalidObjectException;
import dev.shteryu.star_wars.mapper.FilmMapper;
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.service.FilmService;
import dev.shteryu.star_wars.validation.ObjectValidator;
import dev.shteryu.star_wars.web.dto.FilmCreateRequest;
import dev.shteryu.star_wars.web.dto.FilmPeopleGetResponse;
import dev.shteryu.star_wars.web.dto.FilmPeopleUpsertRequest;
import dev.shteryu.star_wars.web.dto.FilmPlanetsGetResponse;
import dev.shteryu.star_wars.web.dto.FilmPlanetsUpsertRequest;
import dev.shteryu.star_wars.web.dto.FilmResponse;
import dev.shteryu.star_wars.web.dto.FilmUpdateRequest;
import dev.shteryu.star_wars.web.dto.StarWarsApiPage;


@RestController
@RequestMapping("/films")
public class FilmController {

    @Autowired
    private ObjectValidator validator;

    @Autowired
    private FilmMapper filmMapper;

    @Autowired
    private FilmService filmService;

    private final Integer PAFE_SIZE = 10;


    @GetMapping(name = "", produces = "application/json")
    public StarWarsApiPage<FilmResponse> getAllFilms(
            @RequestParam(required = false, defaultValue = "0") Integer currentPage) {
        Page<FilmResponse> filmPage =
                filmService.fetchAll(currentPage, PAFE_SIZE).map(filmMapper::responseFromModel);

        return new StarWarsApiPage<>(filmPage);
    }

    @GetMapping(value = "/{filmId}")
    public ResponseEntity<FilmResponse> getFilmById(@PathVariable String filmId) {
        Films film = filmService.findById(filmId);

        return ResponseEntity.ok(filmMapper.responseFromModel(film));
    }

    @PostMapping("")
    public ResponseEntity<FilmResponse> createFilm(@RequestBody FilmCreateRequest filmDto) {

        Map<String, String> validationErrors = validator.validate(filmDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Film Create", validationErrors);
        }

        Films mappedFilm = filmMapper.modelFromCreateRequest(filmDto);
        Films savedFilm = filmService.save(mappedFilm);
        FilmResponse responseFilm = filmMapper.responseFromModel(savedFilm);

        return ResponseEntity.status(201).body(responseFilm);
    }

    @PatchMapping("/{filmId}")
    public ResponseEntity<FilmResponse> updateFilm(@PathVariable String filmId,
            @RequestBody FilmUpdateRequest filmDto) {

        Map<String, String> validationErrors = validator.validate(filmDto);
        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Film Create", validationErrors);
        }

        Films currentFilm = filmService.findById(filmId);

        filmMapper.updateModelFromDto(filmDto, currentFilm);

        Films updatedFilm = filmService.save(currentFilm);

        FilmResponse responseFilm = filmMapper.responseFromModel(updatedFilm);

        return ResponseEntity.status(200).body(responseFilm);
    }

    @DeleteMapping("/{filmId}")
    public void deleteFilmById(@PathVariable String filmId) {
        filmService.deleteById(filmId);
    }

    @PutMapping(value = "/{filmId}/people")
    public FilmPeopleGetResponse setFilmPeople(@PathVariable String filmId,
            @RequestBody FilmPeopleUpsertRequest request) {

        Map<String, String> validationErrors = validator.validate(request);

        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Film People Upsert Request",
                    validationErrors);
        }

        Set<Integer> allFilmPeopleIds =
                filmService.setFilmPeople(filmId, request.getFilmPeopleIds());

        FilmPeopleGetResponse response =
                FilmPeopleGetResponse.builder().filmPeopleIds(allFilmPeopleIds).build();

        return response;
    }

    @PutMapping(value = "/{filmId}/planets")
    public FilmPlanetsGetResponse setFilmPlanets(@PathVariable String filmId,
            @RequestBody FilmPlanetsUpsertRequest request) {

        Map<String, String> validationErrors = validator.validate(request);

        if (validationErrors.size() != 0) {
            throw new InvalidObjectException("Invalid Film Planets Upsert Request",
                    validationErrors);
        }

        Set<Integer> allFilmPlanetsIds =
                filmService.setFilmPlanets(filmId, request.getFilmPlanetsIds());

        FilmPlanetsGetResponse response =
                FilmPlanetsGetResponse.builder().filmPlanetsIds(allFilmPlanetsIds).build();

        return response;
    }
}
