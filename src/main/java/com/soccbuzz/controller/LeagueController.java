package com.soccbuzz.controller;

import com.soccbuzz.model.League;
import com.soccbuzz.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leagues")
public class LeagueController {


    @Autowired
    private LeagueService leagueService;

    @GetMapping
    public ResponseEntity<List<League>> getAllLeagues() {
        List<League> leagues = leagueService.getAllLeagues();
        return ResponseEntity.ok(leagues);
    }

    @GetMapping("/{id}")
    public ResponseEntity<League> getLeagueById(@PathVariable Long id) {
        League league = leagueService.getLeagueById(id);
        return ResponseEntity.ok(league);
    }

    @PostMapping
    public ResponseEntity<League> createLeague(@RequestBody League league) {
        League createdLeague = leagueService.createLeague(league);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdLeague); // Return 201 Created
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteLeague(@PathVariable Long id) {
        leagueService.deleteLeague(id);
        return ResponseEntity.noContent().build(); // Return 204 No Content
    }
}
