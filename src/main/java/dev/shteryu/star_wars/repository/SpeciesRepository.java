package dev.shteryu.star_wars.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.shteryu.star_wars.models.Species;
import jakarta.persistence.GeneratedValue;

@Repository
public interface SpeciesRepository extends CrudRepository<Species, GeneratedValue> {
    
}
