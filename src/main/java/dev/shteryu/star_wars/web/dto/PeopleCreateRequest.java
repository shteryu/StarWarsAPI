package dev.shteryu.star_wars.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PeopleCreateRequest {

    private Integer id;
    private String name;
    private Integer height;
    private Integer mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String url;

}
