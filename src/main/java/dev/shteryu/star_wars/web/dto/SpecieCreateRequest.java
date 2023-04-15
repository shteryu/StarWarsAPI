package dev.shteryu.star_wars.web.dto;

import org.hibernate.validator.constraints.Range;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecieCreateRequest {

    private String name;
    private String classification;
    private String designation;
    @Range(min = 1, message = "i like average_height min 1")
    private int average_height;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    @Range(min = 1, message = "i like average_lifespan min 1")
    private int average_lifespan;
    private String homeworld;
    private String language;

}
