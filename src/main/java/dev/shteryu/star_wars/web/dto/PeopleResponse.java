package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.models.Planets;
import dev.shteryu.star_wars.models.Species;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PeopleResponse {
    
    private Integer id;
    private String name;
    private Integer height;
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String url;
    private Planets homeworld;
    private Set<Films> films;
    private Set<Species> species;
}
