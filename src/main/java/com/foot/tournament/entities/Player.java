package com.foot.tournament.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
@Table(name = "players")
public class Player {
   @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long IdPlayer;

   @Column(name = "name_player",nullable = false)
  private String namePlayer;

   @Column(name = "player_position",nullable = false)
  private String position;


   @ManyToOne(cascade = CascadeType.ALL)
   private Team team;

    public void enrolledInTeam(Team team) {
        this.team=team;
    }
}
