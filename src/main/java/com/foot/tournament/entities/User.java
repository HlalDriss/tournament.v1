package com.foot.tournament.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "users")
@Data @NoArgsConstructor @AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUser;

    @Column(name = "username", nullable = false)
    private  String username;

    @Column(name = "password", nullable = false)
    private  String password;

    @Column(name = "active", nullable = false)
    private  boolean active=true;

    @ManyToMany(mappedBy = "users")
    private List<Role> roles;

    String roless="";
    String permissions="";

    public List<String> getRoleList(){
        List<String> listRoles=new ArrayList<>();
        listRoles= Arrays.asList(this.roless.split(","));
        return listRoles;
    }
    public List<String> getPermissionsList(){
        List<String> listPermissions=new ArrayList<String>();
        listPermissions= Arrays.asList(this.permissions.split(","));
        return listPermissions;
    }

}
