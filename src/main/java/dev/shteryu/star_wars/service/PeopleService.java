package dev.shteryu.star_wars.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import dev.shteryu.star_wars.errors.NotFoundObjectException;
import dev.shteryu.star_wars.models.People;
import dev.shteryu.star_wars.repository.PeoplePagingRepository;
import dev.shteryu.star_wars.repository.PeopleRepository;

@Service
public class PeopleService {

    @Autowired
    private PeopleRepository peopleRepo;

    @Autowired
    private PeoplePagingRepository pagingRepo;

    public People save(People people) {
        return peopleRepo.save(people);
    }

    public Page<People> fetchAll(int currentPage, int pageSize) {
        return pagingRepo.findAll(PageRequest.of(currentPage, pageSize));
    }

    public People findById(String peopleId) {
        return peopleRepo.findById(Long.parseLong(peopleId)).orElseThrow(() -> {
            throw new NotFoundObjectException("Person Not Found", People.class.getName(), peopleId);
        });
    }

    public void deleteById(String peopleId) {
        peopleRepo.deleteById(Long.parseLong(peopleId));
    }
}
