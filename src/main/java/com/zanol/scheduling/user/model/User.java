package com.zanol.scheduling.user.model;

//import org.mindrot.jbcrypt.BCrypt;

import com.zanol.scheduling.security.model.Role;
import com.zanol.scheduling.security.model.SecurityEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User extends SecurityEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String password;
    private LocalDate bornDate;
    private String email;

    @OneToMany(cascade = CascadeType.PERSIST)
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

    public LocalDate getBornDate() {
        return bornDate;
    }

    public void setBornDate(LocalDate bornDate) {
        this.bornDate = bornDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Boolean isValidPassword(String password) {
        try {
            //return BCrypt.checkpw(password, this.getPassword());
            return false;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }

    public void encryptPassword() {
        //this.password = BCrypt.hashpw(this.getPassword(), BCrypt.gensalt());
    }

    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }
}