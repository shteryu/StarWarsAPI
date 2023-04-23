package dev.shteryu.star_wars.integration;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class PeopleEndPointtest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldAddValidPerson() throws Exception {
        mockMvc.perform(post("/people").header("Content-Type", "application/json").content("""
                            {
                                "name": "R2-D2",
                                "height": "96",
                                "mass": "32",
                                "hairColor": "n/a",
                                "skinColor": "white, blue",
                                "eyeColor": "red",
                                "birthYear": "33BBY",
                                "gender": "n/a"
                            }
                        """)).andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value("R2-D2"))
                .andExpect(jsonPath("$.height").value(96))
                .andExpect(jsonPath("$.mass").value(32))
                .andExpect(jsonPath("$.hairColor").value("n/a"))
                .andExpect(jsonPath("$.skinColor").value("white, blue"))
                .andExpect(jsonPath("$.eyeColor").value("red"))
                .andExpect(jsonPath("$.birthYear").value("33BBY"))
                .andExpect(jsonPath("$.gender").value("n/a"));
    }


    @Test
    void shouldThrowValidationErrorForInvalidPerson() throws Exception {
        mockMvc.perform(post("/people").header("Content-Type", "application/json").content("""
                    {
                        "name": "R2-D2",
                                "height": "345",
                                "mass": "34",
                                "hairColor": "n/a",
                                "skinColor": "white, blue",
                                "eyeColor": "red",
                                "birthYear": "33BBY",
                                "gender": "n/a"
                    }
                """)).andExpect(status().isBadRequest())
                .andExpect(jsonPath("$.message").value("Invalid People Create"))
                .andExpect(jsonPath("$.errors").isMap())
                .andExpect(jsonPath("$.errors", CoreMatchers.instanceOf(HashMap.class)))
                .andExpect(jsonPath("$.clazz", CoreMatchers.nullValue()))
                .andExpect(jsonPath("$.id", CoreMatchers.instanceOf(String.class)));
    }

}
