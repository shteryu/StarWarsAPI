package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.models.People;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecieResponse {
    
    private long id;

    private String name;
    private String classification;
    private String designation;
    private int average_height;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    private int average_lifespan;
    private String homeworld;
    private String language;
    private Set<People> people;
    private Set<Films> films;
}
