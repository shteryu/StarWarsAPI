package dev.shteryu.star_wars.web.dto;

import org.hibernate.validator.constraints.Range;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlanetCreateRequest {

    private String name;
    @Range(min = 1, message = "i like rotation_period min 1")
    private int rotation_period;
    @Range(min = 1, message = "i like orbital_period min 1")
    private int orbital_period;
    @Range(min = 1, message = "i like diameter min 1")
    private long diameter;
    private String climate;
    private String gravity;
    private String terrain;
    @Range(min = 1, message = "i like surface_water min 1")
    private int surface_water;
    @Range(min = 1, message = "i like population min 1")
    private long population;
    private String url;

}
