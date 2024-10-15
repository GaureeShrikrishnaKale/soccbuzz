package com.soccbuzz.model;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name = "matches")
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String homeTeam;

    @NotNull
    private String awayTeam;

    @ManyToOne
    @JoinColumn(name = "league_id")
    private League league;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotNull String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(@NotNull String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public @NotNull String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(@NotNull String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public League getLeague() {
        return league;
    }

    public void setLeague(League league) {
        this.league = league;
    }

}
