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
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class People {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int height;
    private int mass;
    private String hair_color;
    private String skin_color;
    private String eye_color;
    private String birth_year;
    private String gender;
    private String url;

    @ManyToOne
    @JoinColumn(name="planet_id")
    private Planets homeworld;

    @ManyToMany
    @JoinTable(
        name = "people_species",
        joinColumns = @JoinColumn(name = "people_id"),
        inverseJoinColumns = @JoinColumn(name = "species_id"))
    private Set<Species> species = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "people_films",
        joinColumns = @JoinColumn(name = "people_id"),
        inverseJoinColumns = @JoinColumn(name = "film_id"))
    private Set<Films> films = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name="people_vehicles",
        joinColumns = @JoinColumn(name = "people_id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private Set<Vehicles> vehicles;

    @ManyToMany
    @JoinTable(
        name="people_starships",
        joinColumns = @JoinColumn(name = "people_id"),
        inverseJoinColumns = @JoinColumn(name = "starship_id"))
    private Set<Starships> starships;
    
}
