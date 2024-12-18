package com.coffee.project.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Drink {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "drink", cascade = CascadeType.ALL)
    private List<Recipe> recipes;

    public Drink(){

    }

    public Drink(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
