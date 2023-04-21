package dev.shteryu.star_wars.models;


import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Films {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id;

    private String title;
    private int episodeId;
    private String openingCrawl;
    private String director;
    private String producer;
    private String releaseDate;

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "people_films",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "people_id"))
    private Set<People> filmPeople = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "planets_films",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "planet_id"))
    private Set<Planets> filmPlanets = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "films_starships",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "starship_id"))
    private Set<Starships> filmStarships = new HashSet<>();

    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "films_vehicle",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private Set<Vehicles> filmVehicles = new HashSet<>();
    
    @JsonIgnore
    @ManyToMany
    @JoinTable(
        name = "films_species",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "species_id"))
    private Set<Species> filmSpecies = new HashSet<>();


}
