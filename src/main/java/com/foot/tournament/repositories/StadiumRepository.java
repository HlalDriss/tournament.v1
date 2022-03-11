package com.foot.tournament.repositories;


import com.foot.tournament.entities.Stadium;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StadiumRepository extends JpaRepository<Stadium,Long> {
     Stadium findByNameStadium(String s);
}
