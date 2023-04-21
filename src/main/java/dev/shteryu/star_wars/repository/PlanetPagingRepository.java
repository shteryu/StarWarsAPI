package dev.shteryu.star_wars.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import dev.shteryu.star_wars.models.Planets;

@Repository
public interface PlanetPagingRepository extends PagingAndSortingRepository<Planets, Long>{
    
}
