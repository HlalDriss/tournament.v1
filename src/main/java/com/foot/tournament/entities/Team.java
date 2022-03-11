package com.foot.tournament.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long IdTeam;

    @Column(name = "name_team",nullable = false)
    private String nameTeam;

    @Column(name = "country",nullable = false)
    private String country;

    @JsonIgnore
    @ManyToMany(mappedBy = "teams",cascade = CascadeType.MERGE)
    private List<Match> matches;

    @JsonIgnore
    @OneToMany(mappedBy = "team",cascade = CascadeType.MERGE)
    private List<Player> players;


}
