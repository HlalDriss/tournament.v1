package com.foot.tournament.repositories;

import com.foot.tournament.entities.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player,Long> {
       Player findByNamePlayer(String s);
}
