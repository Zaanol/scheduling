package com.zanol.scheduling.security;

import javax.persistence.Entity;

@Entity
public class User extends SecurityEntity{

    private String password;

    public User() {
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}