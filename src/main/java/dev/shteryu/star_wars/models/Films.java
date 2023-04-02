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

@Entity
public class Films {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int episode_id;
    private String opening_crawl;
    private String director;
    private String producer;
    private String release_date;

    @ManyToMany(mappedBy = "films")
    private Set<People> characters = new HashSet<>();

    @ManyToMany(mappedBy = "films")
    private Set<Planets> planets = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "films_starships",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "starship_id"))
    private Set<Starships> starships = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "films_vehicle",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "vehicle_id"))
    private Set<Vehicles> vehicles = new HashSet<>();

    @ManyToMany
    @JoinTable(
        name = "films_species",
        joinColumns = @JoinColumn(name = "film_id"),
        inverseJoinColumns = @JoinColumn(name = "species_id"))
    private Set<Species> species = new HashSet<>();

    public int getEpisode_id() {
        return episode_id;
    }

    public void setEpisode_id(int episode_id) {
        this.episode_id = episode_id;
    }

    public String getOpening_crawl() {
        return opening_crawl;
    }

    public void setOpening_crawl(String opening_crawl) {
        this.opening_crawl = opening_crawl;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getRelease_date() {
        return release_date;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public Set<People> getCharacters() {
        return characters;
    }

    public void setCharacters(Set<People> characters) {
        this.characters = characters;
    }

    public Set<Planets> getPlanets() {
        return planets;
    }

    public void setPlanets(Set<Planets> planets) {
        this.planets = planets;
    }

    public Set<Starships> getStarships() {
        return starships;
    }

    public void setStarships(Set<Starships> starships) {
        this.starships = starships;
    }

    public Set<Vehicles> getVehicles() {
        return vehicles;
    }

    public void setVehicles(Set<Vehicles> vehicles) {
        this.vehicles = vehicles;
    }

    public Set<Species> getSpecies() {
        return species;
    }

    public void setSpecies(Set<Species> species) {
        this.species = species;
    }

    public int getId() {
        return id;
    }

}
