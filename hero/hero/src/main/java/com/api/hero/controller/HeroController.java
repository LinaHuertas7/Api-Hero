package com.api.hero.controller;

import com.api.hero.DTO.HeroDTO;
import com.api.hero.service.impl.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/heroes")
public class HeroController {

    @Autowired
    HeroService heroService;

    @PostMapping
    public ResponseEntity<?> saveHero(@RequestBody HeroDTO heroDTO){
        heroService.saveHero(heroDTO);
        return ResponseEntity.status(HttpStatus.OK).body("The superhero has been saved successfully");
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> consultHeroId(@PathVariable Long id){
        HeroDTO heroDTO = heroService.consultHeroId(id);
        if (heroDTO.getId() != null){
            return ResponseEntity.ok(heroDTO);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("The superhero not found");
        }
    }

    @GetMapping
    public Collection<HeroDTO> consultAll (){
        return heroService.consultAll();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteHeroI(@PathVariable Long id){
        if (heroService.consultHeroId(id) != null){
            heroService.deleteHeroId(id);
            return ResponseEntity.status(HttpStatus.OK).body("The superhero has been successfully removed");
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Error deleting");

        }
    }
}
