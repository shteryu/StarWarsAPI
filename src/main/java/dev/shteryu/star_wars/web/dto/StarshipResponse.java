package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import dev.shteryu.star_wars.models.Films;
import dev.shteryu.star_wars.models.People;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StarshipResponse {
    
    private long id;
    private String name;
    private String model;
    private String manufacturer;
    private long cost_in_credits;
    private double length;
    private int max_atmosphering_speed;
    private int crew;
    private int passengers;
    private long cargo_capacity;
    private String consumables;
    private String vehicle_class;
    private String url;
    private Set<People> pilots;
    private Set<Films> films;
}
