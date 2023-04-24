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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Species {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String classification;
    private String designation;
    private int averageHeight;
    private String skinColors;
    private String hairColors;
    private String eyeColors;
    private int averageLifespan;
    private String homeworld;
    private String language;

    @ManyToMany(mappedBy="peopleSpecies")
    private Set<People> speciePeople;

    @ManyToMany(mappedBy = "filmSpecies")
    private Set<Films> specieFilms = new HashSet<>();

}
