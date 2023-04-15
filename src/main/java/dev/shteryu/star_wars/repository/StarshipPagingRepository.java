package dev.shteryu.star_wars.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import dev.shteryu.star_wars.models.Starships;

@Repository
public interface StarshipPagingRepository extends PagingAndSortingRepository<Starships, Integer>{
    
}
