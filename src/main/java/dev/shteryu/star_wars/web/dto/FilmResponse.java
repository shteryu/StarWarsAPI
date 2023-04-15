package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import dev.shteryu.star_wars.models.People;
import dev.shteryu.star_wars.models.Planets;
import dev.shteryu.star_wars.models.Species;
import dev.shteryu.star_wars.models.Starships;
import dev.shteryu.star_wars.models.Vehicles;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class FilmResponse {
    
    private long id;

    private String title;
    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;
    private Set<People> characters;
    private Set<Planets> planets;
    private Set<Starships> starships;
    private Set<Vehicles> vehicles;
    private Set<Species> species;
}
