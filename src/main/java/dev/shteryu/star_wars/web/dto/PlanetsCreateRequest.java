package dev.shteryu.star_wars.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlanetsCreateRequest {

    private String name;
    private int rotation_period;
    private int orbital_period;
    private long diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private int surface_water;
    private long population;
    private String url;

}
