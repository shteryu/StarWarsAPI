package dev.shteryu.star_wars.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.shteryu.star_wars.models.Vehicles;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicles, Integer> {
    
}
