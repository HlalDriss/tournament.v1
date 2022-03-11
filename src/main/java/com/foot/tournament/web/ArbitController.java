package com.foot.tournament.web;

import com.foot.tournament.entities.Arbitrator;
import com.foot.tournament.repositories.ArbitratorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ArbitController {

    @Autowired
   private ArbitratorRepository arbitratorRepository;


    @GetMapping("/arbitrators")
    public List<Arbitrator> getAllArbitrators(){
        return arbitratorRepository.findAll();
    }

    @PostMapping("arbitrators")
    public Arbitrator createArbitrator(@RequestBody Arbitrator arbitrator){
      return  arbitratorRepository.save(arbitrator);
    }

}
