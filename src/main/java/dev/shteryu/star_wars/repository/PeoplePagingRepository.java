package dev.shteryu.star_wars.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import dev.shteryu.star_wars.models.People;

@Repository
public interface PeoplePagingRepository extends PagingAndSortingRepository<People, Integer>{
    
}
