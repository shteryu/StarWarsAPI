package dev.shteryu.star_wars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.shteryu.star_wars.errors.NotFoundObjectException;
import dev.shteryu.star_wars.models.People;
import dev.shteryu.star_wars.repository.PeoplePagingRepository;
import dev.shteryu.star_wars.repository.PeopleRepository;
import dev.shteryu.star_wars.repository.PlanetsRepository;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepo;

    @Autowired
    private PlanetsRepository planetRepo;

    @Autowired
    private PeoplePagingRepository pagingRepo;

    public People save(People people) {
        return peopleRepo.save(people);
    }

    public Page<People> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public People findById(String peopleId) {
        return peopleRepo.findById(Integer.parseInt(peopleId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Person Not Found", People.class.getName(), peopleId);
        });
    }

    public void deleteById(String peopleId) {
        peopleRepo.deleteById(Integer.parseInt(peopleId));
    }

    // public Planets setPeoplePlanet(String peopleId, String planetIds) {
    //     People people = peopleRepo.findById(Integer.parseInt(peopleId)).orElseThrow(() -> {
    //         throw new NotFoundObjectException("People Not Found", People.class.getName(), peopleId);
    //     });

    //     Optional<Planets> planet = planetRepo.findById(Integer.parseInt(planetIds));

    //             planet.setPhotos(new HashSet<>(allPersonPhotos));
    //     Person savedPerson = repo.save(person);

    //     Set<UUID> allPersonPhotoIds = new HashSet<>();
    //     for (Photo photo : savedPerson.getPhotos()) {
    //         allPersonPhotoIds.add(photo.getId());
    //     }

    //     return allPersonPhotoIds;
    // }
}
