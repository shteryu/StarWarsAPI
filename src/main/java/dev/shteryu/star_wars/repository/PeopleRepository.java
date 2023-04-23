package dev.shteryu.star_wars.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import dev.shteryu.star_wars.models.People;

@Repository
public interface PeopleRepository extends CrudRepository<People, Long> {

    @Query("""
        SELECT * FROM PEOPLE WHERE NAME = ?1 OR SKIN_COLOR = ?2 ORDER BY ID DESC
    """)
    List<People> findDistinctPeopleByNameOrSkinColor(String name, String skinColor);

    @Query("""
        SELECT * FROM PEOPLE WHERE NAME ILIKE ?1        
    """)
    List<People> findByNameIgnoreCase(String name);

    @Query("""
        SELECT * FROM PEOPLE WHERE NAME = ?1 ORDER BY NAME ASC        
    """)
    List<People> findByNameOrderByNameAsc(String name);

    @Query("""
            SELECT CASE WHEN COUNT(p) > 0 THEN
            TRUE ELSE FALSE END
            FROM People p
            WHERE p.height = ?1
            
        """)
    boolean existByHeight(Integer height);
    
}
