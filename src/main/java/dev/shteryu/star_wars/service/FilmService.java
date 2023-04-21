package dev.shteryu.star_wars.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.shteryu.star_wars.errors.NotFoundObjectException;
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.models.People;
import dev.shteryu.star_wars.models.Planets;
import dev.shteryu.star_wars.repository.FilmPagingRepository;
import dev.shteryu.star_wars.repository.FilmRepository;
import dev.shteryu.star_wars.repository.PeopleRepository;
import dev.shteryu.star_wars.repository.PlanetRepository;

@Service
public class FilmService {

    @Autowired
    private FilmRepository filmRepo;

    @Autowired
    private PeopleRepository peopleRepo;

    @Autowired
    private PlanetRepository planetsRepo;

    @Autowired
    private FilmPagingRepository pagingRepo;

    public Films save(Films film) {
        return filmRepo.save(film);
    }

    public Page<Films> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Films findById(String filmId) {
        return filmRepo.findById(Long.parseLong(filmId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Film Not Found", Films.class.getName(), filmId);
        });
    }

    public void deleteById(String filmId) {
        filmRepo.deleteById(Long.parseLong(filmId));
    }

    public Set<Long> setFilmPeople(String filmId, Set<Long> filmPeopleIds) {
        Films film = filmRepo.findById(Long.parseLong(filmId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Film Not Found", Films.class.getName(), filmId);
        });

        List<People> allFilmPeople =
                (List<People>) peopleRepo.findAllById(filmPeopleIds);

        film.setFilmPeople(new HashSet<>(allFilmPeople));
        Films savedFilm = filmRepo.save(film);

        Set<Long> allFilmPeopleIds = new HashSet<>();
        for (People people : savedFilm.getFilmPeople()) {
            allFilmPeopleIds.add(people.getId());
        }

        return allFilmPeopleIds;
    }

    public Set<Long> setFilmPlanets(String filmId, Set<Long> filmPlanetsIds) {
        Films film = filmRepo.findById(Long.parseLong(filmId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Film Not Found", Films.class.getName(), filmId);
        });

        List<Planets> allFilmPlanets =
                (List<Planets>) planetsRepo.findAllById(filmPlanetsIds);

        film.setFilmPlanets(new HashSet<>(allFilmPlanets));
        Films savedFilm = filmRepo.save(film);

        Set<Long> allFilmPlanetsIds = new HashSet<>();
        for (Planets planet : savedFilm.getFilmPlanets()) {
            allFilmPlanetsIds.add(planet.getId());
        }

        return allFilmPlanetsIds;
    }
}
