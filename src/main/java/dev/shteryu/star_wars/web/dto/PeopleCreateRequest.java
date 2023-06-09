package dev.shteryu.star_wars.web.dto;

import org.hibernate.validator.constraints.Range;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PeopleCreateRequest {

    @NotNull(message = "i like name not null")
    @NotEmpty(message = "i like name not empty")
    private String name;
    @Range(min = 1, max = 240, message = "i like height from 1 to 240")
    private Integer height;
    @Range(min = 1, max = 240, message = "i like mass from 1 to 240")
    private Double mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String url;

}
