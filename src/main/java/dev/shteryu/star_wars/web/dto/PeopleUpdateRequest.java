package dev.shteryu.star_wars.web.dto;

import org.hibernate.validator.constraints.Range;
import dev.shteryu.star_wars.models.Planets;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PeopleUpdateRequest {

    private String name;
    @Range(min = 1, max = 240, message = "i like height from 1 to 240")
    private Integer height;
    @Range(min = 1, max = 240, message = "i like mass from 1 to 240")
    private Double mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String url;
    private Planets homeworld;
    
}
