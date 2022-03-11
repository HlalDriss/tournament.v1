package com.foot.tournament.web;

import com.foot.tournament.entities.Arbitrator;
import com.foot.tournament.entities.Match;
import com.foot.tournament.entities.Stadium;
import com.foot.tournament.entities.Team;
import com.foot.tournament.repositories.ArbitratorRepository;
import com.foot.tournament.repositories.MatchRepository;
import com.foot.tournament.repositories.StadiumRepository;
import com.foot.tournament.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class MatchController {
    @Autowired
    private MatchRepository matchRepository;
   @Autowired
    private ArbitratorRepository arbitratorRepository;
   @Autowired
   private StadiumRepository stadiumRepository;
   @Autowired
   private TeamRepository teamRepository;

    @GetMapping("/matchs")
    public List<Match> getAllMatchs(){
        return matchRepository.findAll();
    }

   @PostMapping("/matchs")
    public Match createMatch(@RequestBody Match match){
//        Arbitrator arbitrator=arbitratorRepository.save(match.getArbitrator());
//       Stadium stadium=stadiumRepository.save(match.getStadium());
//       List<Team> teams=teamRepository.saveAll(match.getTeams());
//       match.setStadium(stadium);
//       match.setTeams(teams);
//       match.setArbitrator(arbitrator);

         return matchRepository.save(match);
    }

// schedule a two teams match with a stadium and an arbitrator
    @PutMapping("/match/{idMatch}/stadiums/{idStad}/arbitrators/{idArbitr}/teams/{idTeam1}/{idTeam2}")
    public Match scheduleMatch(
            @PathVariable Long idStad,
            @PathVariable Long idMatch,
            @PathVariable Long idArbitr,
            @PathVariable Long idTeam1,
            @PathVariable Long idTeam2
    ){
        Stadium stadium=stadiumRepository.findById(idStad).get();
        Match match=matchRepository.findById(idMatch).get();
        Arbitrator arbitrator=arbitratorRepository.findById(idArbitr).get();
        Team team1=teamRepository.findById(idTeam1).get();
        Team team2=teamRepository.findById(idTeam2).get();

        match.enrolledData(stadium,arbitrator,team1,team2);
        return matchRepository.save(match);
    }

}
