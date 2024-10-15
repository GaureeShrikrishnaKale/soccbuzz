package com.soccbuzz.controller;

import com.soccbuzz.dto.MatchDTO;
import com.soccbuzz.model.Match;
import com.soccbuzz.service.MatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/matches")
public class MatchController {


    @Autowired
    private MatchService matchService;

    @GetMapping
    public List<MatchDTO> getAllMatches() {
        List<Match> matches = matchService.getAllMatches();
        List<MatchDTO> matchDTOS = matches.stream().map(match -> new MatchDTO(match.getId(), match.getHomeTeam(), match.getAwayTeam(), match.getLeague().getName())).collect(Collectors.toList());
        return matchDTOS;
    }

    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<MatchDTO> getMatchById(@PathVariable Long id) {
        Match match = matchService.getMatchById(id);
        MatchDTO matchDTO = new MatchDTO(match.getId(), match.getHomeTeam(), match.getAwayTeam(), match.getLeague().getName());
        return ResponseEntity.ok(matchDTO);
    }

    @PostMapping
    public ResponseEntity<Match> createMatch(@RequestBody Match match) {
        Match createdMatch = matchService.createMatch(match);
        return ResponseEntity.ok(createdMatch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMatch(@PathVariable Long id) {
        matchService.deleteMatch(id);
        return ResponseEntity.noContent().build();
    }
}
