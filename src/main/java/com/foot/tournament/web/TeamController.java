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
public class TeamController {
    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/teams")
    public List<Team> getAllTeam(){
        return teamRepository.findAll();
    }

     @PostMapping("/teams")
    public Team createTeam(@RequestBody Team team){
        return teamRepository.save(team);
    }


}
