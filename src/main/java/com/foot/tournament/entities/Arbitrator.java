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
@Table(name = "arbitrators")
public class Arbitrator {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idArbitr;

     @Column(name = "name", nullable = false)
     private String name;

    @Column(name = "nationality", nullable = false)
     private String nationality;

    @JsonIgnore
     @OneToMany(mappedBy = "arbitrator",cascade = CascadeType.MERGE)
    private List<Match> matches;


}
