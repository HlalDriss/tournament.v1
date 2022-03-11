package com.foot.tournament.web;


import com.foot.tournament.entities.Player;
import com.foot.tournament.entities.Team;
import com.foot.tournament.repositories.PlayerRepository;
import com.foot.tournament.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
     private TeamRepository teamRepository;

    @GetMapping("/players")
    public List<Player> getAllPlayers(){
        return playerRepository.findAll();
    }

    @PostMapping("/players")
    public Player createPlayer(@RequestBody Player player){

        return playerRepository.save(player);
    }
    //Enroll Players in their team
    @PutMapping("/palyer/{idPlayer}/teams/{idTeam}")
    public Player enrolledPlayers(
            @PathVariable Long idTeam,
            @PathVariable Long idPlayer
    ){
        Team team=teamRepository.findById(idTeam).get();
        Player player=playerRepository.findById(idPlayer).get();
        player.enrolledInTeam(team);
       return playerRepository.save(player);

    }
}
