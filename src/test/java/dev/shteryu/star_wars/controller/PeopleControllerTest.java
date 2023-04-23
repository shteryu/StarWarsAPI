package dev.shteryu.star_wars.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import dev.shteryu.star_wars.mapper.PeopleMapper;
import dev.shteryu.star_wars.models.People;
import dev.shteryu.star_wars.service.PeopleService;
import dev.shteryu.star_wars.validation.ObjectValidator;
import dev.shteryu.star_wars.web.PeopleController;

@WebMvcTest(PeopleController.class)
public class PeopleControllerTest {


    @MockBean
    private PeopleService peopleService;

    @MockBean
    private PeopleMapper peopleMapper;

    @MockBean
    private ObjectValidator validator;

    @InjectMocks
    private PeopleController controller;

    @Autowired
    private MockMvc mockMvc;


    @Test
    void shouldHavePaginationOnFetchAll() throws Exception {
        // when service called fetchAll -> return empty result
        Page<People> emptyPeoplePage = new PageImpl<>(
            Collections.emptyList(), 
            PageRequest.of(0, 10) , 0);
        when(peopleService.fetchAll(0, 10)).thenReturn(emptyPeoplePage);
       
        mockMvc.perform(
            get("/people")
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.pagination.currentPage").value(0))
            .andExpect(jsonPath("$.pagination.pageSize").value(10))
            .andExpect(jsonPath("$.pagination.totalElements").value(0));
    }

    @Test
    void shouldReturnBadRequestWithErrors() throws Exception {

        Map<String, String> validationErrors = new HashMap<>();
        validationErrors.put("mass", "cannot be negative");

        when(
            validator.validate(any())
        ).thenReturn(validationErrors);
        
        mockMvc.perform(post("/people")
        .contentType(MediaType.APPLICATION_JSON)
        .content("""
            {
                "name": "R2-D2",
                "height": "50",
                "mass": "400",
                "hairColor": "n/a",
                "skinColor": "white, blue",
                "eyeColor": "red",
                "birthYear": "33BBY",
                "gender": "n/a"
            }
            """))
            .andExpect(status().isBadRequest())
            .andExpect(jsonPath("$.message").value("Invalid People Create"));
    }

    
}
