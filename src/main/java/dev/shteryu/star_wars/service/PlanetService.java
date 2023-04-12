package dev.shteryu.star_wars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.shteryu.star_wars.errors.NotFoundObjectException;
import dev.shteryu.star_wars.models.People;
import dev.shteryu.star_wars.models.Planets;
import dev.shteryu.star_wars.repository.PlanetPagingRepository;
import dev.shteryu.star_wars.repository.PlanetsRepository;

@Service
public class PlanetService {

    @Autowired
    private PlanetsRepository planetRepo;

    @Autowired
    private PlanetPagingRepository pagingRepo;

    public Planets save(Planets planets) {
        return planetRepo.save(planets);
    }

    public Page<Planets> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public Planets findById(String planetId) {
        return planetRepo.findById(Integer.parseInt(planetId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Planet Not Found", People.class.getName(), planetId);
        });
    }

    public void deleteById(String planetId) {
        planetRepo.deleteById(Integer.parseInt(planetId));
    }

    // public Set<UUID> setPersonPhotos(String personId, Set<UUID> personPhotoIds) {
    //     Person person = repo.findById(UUID.fromString(personId)).orElseThrow(() -> {
    //         throw new NotFoundObjectException("Person Not Found", Person.class.getName(), personId);
    //     });

    //     List<Photo> allPersonPhotos =
    //             (List<Photo>) photoRepo.findAllById(personPhotoIds);

    //     person.setPhotos(new HashSet<>(allPersonPhotos));
    //     Person savedPerson = repo.save(person);

    //     Set<UUID> allPersonPhotoIds = new HashSet<>();
    //     for (Photo photo : savedPerson.getPhotos()) {
    //         allPersonPhotoIds.add(photo.getId());
    //     }

    //     return allPersonPhotoIds;
    // }
}
