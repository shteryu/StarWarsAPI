package dev.shteryu.star_wars.json;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.json.JsonContent;
import dev.shteryu.star_wars.web.dto.PeopleResponse;

@JsonTest
public class PeopleSerializationTest {

    @Autowired
    private JacksonTester<PeopleResponse> peopleResponseJacksontester;


    @Test
    void serializeResponse() throws Exception {

        PeopleResponse response = PeopleResponse.builder()
            .name("R2-D2")
            .height(185)
            .mass(32)
            .hairColor("red")
            .skinColor("white, blue")
            .eyeColor("red")
            .birthYear("33BBY")
            .gender("n/a")
            .build();

        JsonContent<PeopleResponse> parsedJson = peopleResponseJacksontester.write(response);

        assertThat(parsedJson).extractingJsonPathStringValue("$.name").isEqualTo("R2-D2");
        assertThat(parsedJson).extractingJsonPathValue("$.height").isEqualTo(185);
        assertThat(parsedJson).extractingJsonPathValue("$.mass").isEqualTo(32);
        assertThat(parsedJson).extractingJsonPathStringValue("$.hairColor").isEqualTo("red");
        assertThat(parsedJson).extractingJsonPathStringValue("$.skinColor").isEqualTo("white, blue");
        assertThat(parsedJson).extractingJsonPathStringValue("$.eyeColor").isEqualTo("red");
        assertThat(parsedJson).extractingJsonPathStringValue("$.birthYear").isEqualTo("33BBY");
        assertThat(parsedJson).extractingJsonPathStringValue("$.gender").isEqualTo("n/a");
    }

    @Test
    void deserializeResponse() throws Exception {
        String responseObject = """
            {
                "id": 10,
                "name": "R2-D2",
                "height": 96,
                "mass": 32,
                "hairColor": "n/a",
                "skinColor": "white, blue",
                "eyeColor": "red",
                "birthYear": "33BBY",
                "gender": null,
                "url": null,
                "planets": null
            }
        """;

        PeopleResponse response = peopleResponseJacksontester.parse(responseObject).getObject();

        assertEquals(response.getId(), 10);
        assertEquals(response.getName(), "R2-D2");
        assertEquals(response.getHeight(), 96);
        assertEquals(response.getMass(), 32);
        assertEquals(response.getHairColor(), "n/a");
        assertEquals(response.getSkinColor(), "white, blue");
        assertEquals(response.getEyeColor(), "red");
        assertEquals(response.getBirthYear(), "33BBY");
        assertEquals(response.getGender(), null);
        assertEquals(response.getUrl(), null);
        
    }

    
}
