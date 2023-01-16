package com.api.hero.service;

import com.api.hero.DTO.HeroDTO;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public interface IHeroService {

    void saveHero(HeroDTO heroDTO);
    HeroDTO consultHeroId (Long id);
    void deleteHeroId(Long id);
    Collection<HeroDTO> consultAll();
}
