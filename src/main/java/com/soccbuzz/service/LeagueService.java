package com.soccbuzz.service;

import com.soccbuzz.exceptionHandler.EntityNotFoundException;
import com.soccbuzz.model.League;
import com.soccbuzz.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeagueService {

    @Autowired
    private LeagueRepository leagueRepository;

    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    public League getLeagueById(Long id) {
        return leagueRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("League not found with id " + id));
    }

    public League createLeague(League league) {
        return leagueRepository.save(league);
    }

    public void deleteLeague(Long id) {
        leagueRepository.deleteById(id);
    }
}
