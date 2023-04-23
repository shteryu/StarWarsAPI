package dev.shteryu.star_wars.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.jdbc.Sql;
import dev.shteryu.star_wars.models.People;

@DataJpaTest
public class PersonCrudRepositoryTest {

    @Autowired
    private PeopleRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    @Sql("classpath:db/singlePerson.sql")
    void shouldFetchPersonByIdFromDb() {
        String existingID = "10";
        Optional<People> peopleOptional = repository.findById(Long.parseLong(existingID));

        assertTrue(peopleOptional.isPresent());

        People people = peopleOptional.get();

        assertEquals(people.getHeight(), Integer.valueOf(180));
    }

    @Test
    void shouldFetchPersonByIdPersistedViaEM() {

        Long personId = Long.parseLong("10");
        People people = People.builder()
                        .name("R2-D2")
                        .height(180)
                        .mass(32.0)
                        .hairColor("n/a")
                        .skinColor("white, blue")
                        .eyeColor("red")
                        .birthYear("33BBY")
                        .gender("n/a")
                        .build();

        People persistedPeople = entityManager.persist(people);

        assertTrue(repository.findById(persistedPeople.getId()).isPresent());
    }


    @Test
    void shouldExistPeopleByHeight() {

        Integer height = 150;
        Integer invalidHeight = -180;
        People people = People.builder()
                        .name("R2-D2")
                        .height(height)
                        .mass(32.0)
                        .hairColor("n/a")
                        .skinColor("white, blue")
                        .eyeColor("red")
                        .birthYear("33BBY")
                        .gender("n/a")
                        .build();


        People persistedPeople = entityManager.persist(people);

        assertTrue(repository.existByHeight(height));
        assertFalse(repository.existByHeight(invalidHeight));
    }

}
