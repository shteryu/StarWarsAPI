package dev.shteryu.star_wars.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PeopleUpdateRequest {

    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String url;
    private Integer planet_id;
    
}
