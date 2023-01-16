package com.api.hero.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "hero")
@Getter @Setter
public class Hero {

    @Id
    private Long id;
    private String name;
    private String power;
    private String mainPhoto;
    private String coverPhoto;
    private String description;

    public Hero() {
    }

    public Hero(Long id, String name, String power, String mainPhoto, String coverPhoto, String description) {
        this.id = id;
        this.name = name;
        this.power = power;
        this.mainPhoto = mainPhoto;
        this.coverPhoto = coverPhoto;
        this.description = description;
    }

    public Hero(String name, String power, String mainPhoto, String coverPhoto, String description) {
        this.name = name;
        this.power = power;
        this.mainPhoto = mainPhoto;
        this.coverPhoto = coverPhoto;
        this.description = description;
    }
}
