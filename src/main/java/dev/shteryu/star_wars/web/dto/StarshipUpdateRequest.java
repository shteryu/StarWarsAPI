package dev.shteryu.star_wars.web.dto;

import org.hibernate.validator.constraints.Range;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StarshipUpdateRequest {

    private String name;
    private String model;
    private String manufacturer;
    @Range(min = 1, message = "i like cost_in_credits min 1")
    private long cost_in_credits;
    @Range(min = 1, message = "i like length min 1")
    private double length;
    @Range(min = 1, message = "i like max_atmosphering_speed min 1")
    private int max_atmosphering_speed;
    @Range(min = 1, message = "i like crew min 1")
    private int crew;
    @Range(min = 1, message = "i like passengers min 1")
    private int passengers;
    @Range(min = 1, message = "i like cargo_capacity min 1")
    private long cargo_capacity;
    private String consumables;
    private String vehicle_class;
    private String url;
    
}
