package com.foot.tournament.repositories;


import com.foot.tournament.entities.Arbitrator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArbitratorRepository extends JpaRepository<Arbitrator,Long> {
       Arbitrator findByName(String name);
}
