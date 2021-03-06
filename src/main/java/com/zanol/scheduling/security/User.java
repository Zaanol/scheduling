package com.zanol.scheduling.security;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends SecurityEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;

    @OneToMany(cascade=CascadeType.PERSIST)
    private List<Role> roles = new ArrayList<>();

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public Long getId() {
        return id;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}