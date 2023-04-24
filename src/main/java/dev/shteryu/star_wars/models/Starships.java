package dev.shteryu.star_wars.models;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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
public class Starships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String name;
    private String model;
    private String manufacturer;
    private long costInCredits;
    private double length;
    private int maxAtmospheringSpeed;
    private int crew;
    private int passengers;
    private long cargoCapacity;
    private String consumables;
    private String vehicleClass;
    private String url;

    @ManyToMany(mappedBy = "peopleStarships")
    private Set<People> starshipPeople;

    @ManyToMany(mappedBy = "filmStarships")
    private Set<Films> starshipFilms;

}
