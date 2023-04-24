package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.models.People;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecieResponse {
    
    private Long id;

    private String name;
    private String classification;
    private String designation;
    private int averageHeight;
    private String skinColors;
    private String hairColors;
    private String eyeColors;
    private int averageLifespan;
    private String homeworld;
    private String language;
    @JsonIgnoreProperties("speciePeople")
    @JsonProperty(value = "people")
    private Set<People> speciePeople;
    @JsonIgnoreProperties("specieFilms")
    @JsonProperty(value = "films")
    private Set<Films> specieFilms;
}
