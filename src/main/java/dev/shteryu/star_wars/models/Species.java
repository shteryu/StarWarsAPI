package dev.shteryu.star_wars.models;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Species {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public int getAverage_height() {
        return average_height;
    }

    public void setAverage_height(int average_height) {
        this.average_height = average_height;
    }

    public String getSkin_colors() {
        return skin_colors;
    }

    public void setSkin_colors(String skin_colors) {
        this.skin_colors = skin_colors;
    }

    public String getHair_colors() {
        return hair_colors;
    }

    public void setHair_colors(String hair_colors) {
        this.hair_colors = hair_colors;
    }

    public String getEye_colors() {
        return eye_colors;
    }

    public void setEye_colors(String eye_colors) {
        this.eye_colors = eye_colors;
    }

    public int getAverage_lifespan() {
        return average_lifespan;
    }

    public void setAverage_lifespan(int average_lifespan) {
        this.average_lifespan = average_lifespan;
    }

    public String getHomeworld() {
        return homeworld;
    }

    public void setHomeworld(String homeworld) {
        this.homeworld = homeworld;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Set<People> getPeople() {
        return people;
    }

    public void setPeople(Set<People> people) {
        this.people = people;
    }

    public Set<Films> getFilms() {
        return films;
    }

    public void setFilms(Set<Films> films) {
        this.films = films;
    }

    public long getId() {
        return id;
    }

}
