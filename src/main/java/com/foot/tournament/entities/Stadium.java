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
@Table(name = "stadiums")
public class Stadium {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long idStadium;

    @Column(name = "name_stadium",nullable = false)
    private String nameStadium;

    @Column(name = "city_stadium",nullable = false)
    private String city;

    @JsonIgnore
    @OneToMany(mappedBy = "stadium",cascade = CascadeType.MERGE)
    private List<Match> matches;

    public void assignMatch(Match match) {
        matches.add(match);
    }
}
