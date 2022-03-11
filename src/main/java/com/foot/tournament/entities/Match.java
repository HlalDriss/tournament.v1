package com.foot.tournament.entities;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "matchs")
public class Match {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long IdMatch;

    @Column(name = "date_match",nullable = false)
    @Temporal(TemporalType.DATE)
    private Date dateMatch;

    @Column(name = "hour_match",nullable = false)
    private String hourMatch;


    @ManyToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    @JoinTable(name = "match_team",
            joinColumns = { @JoinColumn(name = "IdMatch") },
            inverseJoinColumns= { @JoinColumn(name = "IdTeam") })
    List<Team> teams;



    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Stadium stadium;


   @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
    private Arbitrator arbitrator;

    public void enrolledStadium(Stadium stadium) {
        this.stadium=stadium;
    }

    public void enrolledData(Stadium stadium, Arbitrator arbitrator, Team team1, Team team2) {
        this.stadium=stadium;
        this.arbitrator=arbitrator;
        teams.add(team1);
        teams.add(team2);
    }
}
