package com.api.hero.repository;

import com.api.hero.model.Hero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IHeroRepository extends JpaRepository<Hero, Long> {
}
