package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.models.Planets;
import dev.shteryu.star_wars.models.Species;
import dev.shteryu.star_wars.models.Starships;
import dev.shteryu.star_wars.models.Vehicles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PeopleResponse {
    
    private Long id;
    private String name;
    private Integer height;
    private Integer mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String url;
    @JsonIgnoreProperties("peoplePlanets")
    @JsonProperty(value = "planets")
    private Planets peoplePlanets;
    @JsonIgnoreProperties("peopleFilms")
    @JsonProperty(value = "films")
    private Set<Films> peopleFilms;
    @JsonIgnoreProperties("peopleSpecies")
    @JsonProperty(value = "species")
    private Set<Species> peopleSpecies;
    @JsonIgnoreProperties("peopleVehicles")
    @JsonProperty(value = "vehicles")
    private Set<Vehicles> peopleVehicles;
    @JsonIgnoreProperties("peopleStarships")
    @JsonProperty(value = "starships")
    private Set<Starships> peopleStarships;

}
