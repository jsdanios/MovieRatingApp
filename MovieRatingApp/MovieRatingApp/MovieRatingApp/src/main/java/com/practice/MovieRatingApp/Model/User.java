package com.practice.MovieRatingApp.Model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

import org.hibernate.validator.constraints.Length;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Length(min = 3, message = "Your username must have at least 3 characters")
    @Length(max = 15, message = "Your username cannot have more than 15 characters")
    @Pattern(regexp = "[^\\s]+", message = "Your username cannot contain spaces")
    private String username;

    @Length(min = 5, message = "Your password must have at least 5 characters")
    @JsonProperty(access = Access.WRITE_ONLY)
    private String password;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Role> roles;

    private int active;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Movie> votedUp;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Movie> votedDown;

    public User() {
        super();
    }

    public User(Long id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public User(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public List<Movie> getVotedUp() {
        return votedUp;
    }

    public void setVotedUp(List<Movie> votedUp) {
        this.votedUp = votedUp;
    }

    public List<Movie> getVotedDown() {
        return votedDown;
    }

    public void setVotedDown(List<Movie> votedDown) {
        this.votedDown = votedDown;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
}
