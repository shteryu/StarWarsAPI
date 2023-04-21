package dev.shteryu.star_wars.web.dto;

import org.hibernate.validator.constraints.Range;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmCreateRequest {

    private String title;
    @Range(min = 0, max = 10, message = "i like episode from 0 to 10")
    private int episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private String releaseDate;

}
