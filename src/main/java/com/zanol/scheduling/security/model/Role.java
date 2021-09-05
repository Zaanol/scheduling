package com.zanol.scheduling.security.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Role extends SecurityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(cascade = CascadeType.PERSIST)
    private List<Permission> permissions = new ArrayList<>();

    @Override
    public Long getId() {
        return id;
    }

    public List<Permission> getPermissions() {
        return permissions;
    }

    public void setPermissions(List<Permission> permissions) {
        this.permissions = permissions;
    }
}