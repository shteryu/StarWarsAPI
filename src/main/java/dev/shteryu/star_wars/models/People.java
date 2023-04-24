package dev.shteryu.star_wars.models;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int height;
    private Double mass;
    private String hairColor;
    private String skinColor;
    private String eyeColor;
    private String birthYear;
    private String gender;
    private String url;

    @ManyToOne
    @JoinColumn(name = "planetId")
    private Planets peoplePlanets;

    @ManyToMany
    @JoinTable(name = "people_species", joinColumns = @JoinColumn(name = "people_id"),
            inverseJoinColumns = @JoinColumn(name = "species_id"))
    private Set<Species> peopleSpecies = new HashSet<>();

    @ManyToMany(mappedBy = "filmPeople")
    private Set<Films> peopleFilms = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "people_vehicles", joinColumns = @JoinColumn(name = "people_id"),
            inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private Set<Vehicles> peopleVehicles = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "people_starships", joinColumns = @JoinColumn(name = "people_id"),
            inverseJoinColumns = @JoinColumn(name = "starship_id"))
    private Set<Starships> peopleStarships = new HashSet<>();

}
