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
public class PlanetResponse {
    
    private Long id;
    private String name;
    private int rotationPeriod;
    private int orbitalPeriod;
    private long diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private int surfaceWater;
    private long population;
    private String url;
    @JsonIgnoreProperties("planetPeople")
    @JsonProperty(value = "residents")
    private Set<People> planetPeople;
    @JsonIgnoreProperties("planetFilms")
    @JsonProperty(value = "films")
    private Set<Films> planetFilms;
}
