package dev.shteryu.star_wars.models;

import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
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
public class Planets {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int rotationPeriod;
    private int orbitalPeriod;
    private long diameter;
    private String climate;
    private String gravity;
    private String terrain;
    private int surfaceWater;
    private long population;
    private String url;

    @JsonIgnore
    @OneToMany(mappedBy="peoplePlanets")
    private Set<People> planetPeople;

    @JsonIgnore
    @ManyToMany(mappedBy = "filmPlanets")
    private Set<Films> planetFilms = new HashSet<Films>();

}
