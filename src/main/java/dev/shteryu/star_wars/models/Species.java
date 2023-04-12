package dev.shteryu.star_wars.models;

import java.util.HashSet;
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
public class Species {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;
    private String classification;
    private String designation;
    private int average_height;
    private String skin_colors;
    private String hair_colors;
    private String eye_colors;
    private int average_lifespan;
    private String homeworld;
    private String language;

    @ManyToMany(mappedBy="species")
    private Set<People> people;

    @ManyToMany(mappedBy = "species")
    private Set<Films> films = new HashSet<>();

}
