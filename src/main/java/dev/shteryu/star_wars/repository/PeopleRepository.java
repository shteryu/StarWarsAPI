package dev.shteryu.star_wars.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.shteryu.star_wars.models.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, Long> {

    List<People> findDistinctPeopleByNameOrSkinColor(String name, String skinColor);

    List<People> findByNameIgnoreCase(String name);

    List<People> findByNameOrderByNameAsc(String name);

    @Query("""
            SELECT CASE WHEN COUNT(p) > 0 THEN
            TRUE ELSE FALSE END
            FROM People p
            WHERE p.height = ?1
            
        """)
    boolean existByHeight(Integer height);
    
}
