package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;
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
    
    private Long id;
    private String title;
    private int episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private String releaseDate;
    @JsonProperty(value = "characters")
    private Set<People> filmPeople;
    @JsonProperty(value = "planets")
    private Set<Planets> filmPlanets;
    @JsonProperty(value = "starships")
    private Set<Starships> filmStarships;
    @JsonProperty(value = "vehicles")
    private Set<Vehicles> filmVehicles;
    @JsonProperty(value = "species")
    private Set<Species> filmSpecies;
}
