package dev.shteryu.star_wars.models;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Planets {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private int rotation_period;
    private int orbital_period;
    private long diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private int surface_water;
    private long population;
    private String url;

    @OneToMany(mappedBy="homeworld")
    private Set<People> residents;

    @ManyToMany(mappedBy = "planets")
    private Set<Films> films = new HashSet<>();

}
