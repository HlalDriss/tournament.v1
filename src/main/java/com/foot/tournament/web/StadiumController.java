package com.foot.tournament.web;

import com.foot.tournament.entities.Match;
import com.foot.tournament.entities.Stadium;
import com.foot.tournament.repositories.MatchRepository;
import com.foot.tournament.repositories.StadiumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StadiumController {
     @Autowired
    private StadiumRepository stadiumRepository;

     @Autowired
     private MatchRepository matchRepository;

       @GetMapping("stadiums")
     public List<Stadium> getAllStadium(){
         return stadiumRepository.findAll();
     }

     @PostMapping("/stadiums")
     public Stadium createStium(@RequestBody Stadium stadium){
         return stadiumRepository.save(stadium);
     }



}
