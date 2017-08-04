package org.arpit.java2blog.model;

import javax.persistence.*;

@Entity
@Table(name = "COUNTRY")
public class Country {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "countryName")
    String countryName;

    @Column(name = "population")
    long population;

    public Country() {
        super();
    }

    public Country(int id, String countryName, long population) {
        super();
        this.id = id;
        this.countryName = countryName;
        this.population = population;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public int getId() {
        return id;
    }

    public String getCountryName() {
        return countryName;
    }

    public long getPopulation() {
        return population;
    }
}
