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

@Entity
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

    public Planets getHomeworld() {
        return homeworld;
    }
    public void setHomeworld(Planets homeworld) {
        this.homeworld = homeworld;
    }
    public Set<Species> getSpecies() {
        return species;
    }
    public void setSpecies(Set<Species> species) {
        this.species = species;
    }
    public Set<Films> getFilms() {
        return films;
    }
    public void setFilms(Set<Films> films) {
        this.films = films;
    }
    public Set<Vehicles> getVehicles() {
        return vehicles;
    }
    public void setVehicles(Set<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }
    public Set<Starships> getStarships() {
        return starships;
    }
    public void setStarships(Set<Starships> starships) {
        this.starships = starships;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHeight() {
        return height;
    }
    public void setHeight(int height) {
        this.height = height;
    }
    public int getMass() {
        return mass;
    }
    public void setMass(int mass) {
        this.mass = mass;
    }
    public String getHair_color() {
        return hair_color;
    }
    public void setHair_color(String hair_color) {
        this.hair_color = hair_color;
    }
    public String getSkin_color() {
        return skin_color;
    }
    public void setSkin_color(String skin_color) {
        this.skin_color = skin_color;
    }
    public String getEye_color() {
        return eye_color;
    }
    public void setEye_color(String eye_color) {
        this.eye_color = eye_color;
    }
    public String getBirth_year() {
        return birth_year;
    }
    public void setBirth_year(String birth_year) {
        this.birth_year = birth_year;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public int getId() {
        return id;
    }

    
}
