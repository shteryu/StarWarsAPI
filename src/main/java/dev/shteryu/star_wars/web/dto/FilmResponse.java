package dev.shteryu.star_wars.web.dto;

import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
    @JsonIgnoreProperties("filmPeople")
    @JsonProperty(value = "characters")
    private Set<People> filmPeople;
    @JsonIgnoreProperties("filmPlanets")
    @JsonProperty(value = "planets")
    private Set<Planets> filmPlanets;
    @JsonIgnoreProperties("filmStarships")
    @JsonProperty(value = "starships")
    private Set<Starships> filmStarships;
    @JsonIgnoreProperties("filmVehicles")
    @JsonProperty(value = "vehicles")
    private Set<Vehicles> filmVehicles;
    @JsonIgnoreProperties("filmSpecies")
    @JsonProperty(value = "species")
    private Set<Species> filmSpecies;
}
