package dev.shteryu.star_wars.models;

import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Starships {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public long getCost_in_credits() {
        return cost_in_credits;
    }

    public void setCost_in_credits(long cost_in_credits) {
        this.cost_in_credits = cost_in_credits;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getMax_atmosphering_speed() {
        return max_atmosphering_speed;
    }

    public void setMax_atmosphering_speed(int max_atmosphering_speed) {
        this.max_atmosphering_speed = max_atmosphering_speed;
    }

    public int getCrew() {
        return crew;
    }

    public void setCrew(int crew) {
        this.crew = crew;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public long getCargo_capacity() {
        return cargo_capacity;
    }

    public void setCargo_capacity(long cargo_capacity) {
        this.cargo_capacity = cargo_capacity;
    }

    public String getConsumables() {
        return consumables;
    }

    public void setConsumables(String consumables) {
        this.consumables = consumables;
    }

    public String getVehicle_class() {
        return vehicle_class;
    }

    public void setVehicle_class(String vehicle_class) {
        this.vehicle_class = vehicle_class;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Set<People> getPilots() {
        return pilots;
    }

    public void setPilots(Set<People> pilots) {
        this.pilots = pilots;
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
