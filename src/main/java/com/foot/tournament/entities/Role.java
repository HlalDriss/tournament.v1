package com.foot.tournament.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "role")
@Data @NoArgsConstructor @AllArgsConstructor
public class Role {
    @Id
    private String role;
    @ManyToMany
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "role")},
            inverseJoinColumns = {@JoinColumn(name = "id_user")}
    )
   private List<User> users;
}
