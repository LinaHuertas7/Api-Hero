package com.api.hero.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class HeroDTO {

    private Long id;
    private String name;
    private String power;
    private String mainPhoto;
    private String coverPhoto;
    private String description;

    @Override
    public String toString(){
        return "HeroDTO {" +
                "id = " + id + '\'' +
                ", name = " + name + '\'' +
                ", power = " + power + '\'' +
                ", main photo = " + mainPhoto + '\'' +
                ", cover photo = " + coverPhoto + '\'' +
                ", description = " + description + '\'' +
                '}';
    }
}
