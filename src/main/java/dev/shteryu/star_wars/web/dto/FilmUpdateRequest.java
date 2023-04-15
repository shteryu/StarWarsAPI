package dev.shteryu.star_wars.web.dto;

import org.hibernate.validator.constraints.Range;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmUpdateRequest {

    private String title;
    @Range(min = 0, max = 10, message = "i like episode from 0 to 10")
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    
}
