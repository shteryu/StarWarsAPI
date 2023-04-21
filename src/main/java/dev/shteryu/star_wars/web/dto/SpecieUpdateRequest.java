package dev.shteryu.star_wars.web.dto;

import org.hibernate.validator.constraints.Range;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecieUpdateRequest {

    private String name;
    private String classification;
    private String designation;
    @Range(min = 1, message = "i like average_height min 1")
    private int averageHeight;
    private String skinColors;
    private String hairColors;
    private String eyeColors;
    @Range(min = 1, message = "i like average_lifespan min 1")
    private int averageLifespan;
    private String homeworld;
    private String language;
    
}
