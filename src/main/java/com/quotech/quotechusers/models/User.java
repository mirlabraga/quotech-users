package com.quotech.quotechusers.models;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.sql.rowset.serial.SerialArray;
import java.io.Serializable;

@Entity
public class User implements Serializable {

    @EmbeddedId
    private UserId userId;

    private String name;

    private String email;

    private String role;

    public User() {
    }

    public User(UserId userId, String name, String email, String role) {
        this.userId = userId;
        this.name = name;
        this.email = email;
        this.role = role;
    }

    public UserId getId() {
        return userId;
    }

    public void setId(UserId userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId=" + userId.getUserId() + "-" + userId.getClientId() + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
