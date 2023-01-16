package com.api.hero.service.impl;

import com.api.hero.DTO.HeroDTO;
import com.api.hero.model.Hero;
import com.api.hero.repository.IHeroRepository;
import com.api.hero.service.IHeroService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

import org.apache.log4j.Logger;

@Service
public class HeroService implements IHeroService {

    @Autowired
    IHeroRepository heroRepository;

    @Autowired
    private ObjectMapper mapper;

    //Logger
    final static Logger logger = Logger.getLogger(HeroService.class);

    @Override
    public void saveHero(HeroDTO heroDTO){
        Hero hero = mapper.convertValue(heroDTO, Hero.class);
        heroRepository.save(hero);
        logger.info("The superhero with id: " + heroDTO.getId() + " has been saved successfully");
    }

    @Override
    public HeroDTO consultHeroId(Long id){
        HeroDTO heroDTO = null;
        Optional<Hero> hero = heroRepository.findById(id);
        if (hero.isPresent()){
            heroDTO = mapper.convertValue(hero, HeroDTO.class);
            logger.info("The superhero with id: " + heroDTO.getId() + " has been consult successfully");
        }else{
            logger.error("The superhero with id: " + heroDTO.getId() + " not found");
        }
        return heroDTO;
    }

    @Override
    public void deleteHeroId(Long id){
        heroRepository.deleteById(id);
        logger.info("The superhero has been successfully removed");
    }

    @Override
    public Collection<HeroDTO> consultAll(){
        List<Hero> heroes = heroRepository.findAll((Sort.by(Sort.Direction.DESC,"id")));

        Set<HeroDTO> heroesDTOS = new HashSet<>();
        for (Hero hero : heroes){
            heroesDTOS.add(mapper.convertValue(hero, HeroDTO.class));
        }
        logger.info("Se consultaron todos los heroes con exito");
        return heroesDTOS;
    }
}
