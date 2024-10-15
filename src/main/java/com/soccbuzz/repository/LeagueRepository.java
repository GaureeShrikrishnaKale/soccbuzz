package com.soccbuzz.repository;


import com.soccbuzz.model.League;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LeagueRepository extends JpaRepository<League, Long> {

}
