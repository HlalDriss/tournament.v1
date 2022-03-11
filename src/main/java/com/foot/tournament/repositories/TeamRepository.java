package com.foot.tournament.repositories;


import com.foot.tournament.entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
     Team findByNameTeam(String s);
}
