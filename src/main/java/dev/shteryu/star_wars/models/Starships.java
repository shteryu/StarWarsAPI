package dev.shteryu.star_wars.models;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Starships {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    private String name;
    private String model;
    private String manufacturer;
    private long cost_in_credits;
    private double length;
    private int max_atmosphering_speed;
    private int crew;
    private int passengers;
    private long cargo_capacity;
    private String consumables;
    private String vehicle_class;
    private String url;

    @ManyToMany(mappedBy = "starships")
    private Set<People> pilots;

    @ManyToMany(mappedBy = "starships")
    private Set<Films> films;

}
