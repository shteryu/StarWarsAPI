package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.models.People;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StarshipResponse {
    
    private Long id;
    private String name;
    private String model;
    private String manufacturer;
    private long costInCredits;
    private double length;
    private int maxAtmospheringSpeed;
    private int crew;
    private int passengers;
    private long cargoCapacity;
    private String consumables;
    private String vehicleClass;
    private String url;
    @JsonProperty(value = "pilots")
    private Set<People> starshipPilots;
    @JsonProperty(value = "films")
    private Set<Films> starshipFilms;
}
