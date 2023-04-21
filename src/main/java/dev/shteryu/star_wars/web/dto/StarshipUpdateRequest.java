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
    private long costInCredits;
    @Range(min = 1, message = "i like length min 1")
    private double length;
    @Range(min = 1, message = "i like max_atmosphering_speed min 1")
    private int maxAtmospheringSpeed;
    @Range(min = 1, message = "i like crew min 1")
    private int crew;
    @Range(min = 1, message = "i like passengers min 1")
    private int passengers;
    @Range(min = 1, message = "i like cargo_capacity min 1")
    private long cargoCapacity;
    private String consumables;
    private String vehicleClass;
    private String url;
    
}
