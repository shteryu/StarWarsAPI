package dev.shteryu.star_wars.web.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmsDto {

    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    
}
