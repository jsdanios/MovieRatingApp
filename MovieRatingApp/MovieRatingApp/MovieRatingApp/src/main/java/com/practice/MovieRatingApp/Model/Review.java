package com.practice.MovieRatingApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Movie movie;

    private String content;

    public Review(Long id, User user, Movie movie, String content) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.content = content;
    }

    public Review(User user, Movie movie, String content) {
        this.user = user;
        this.movie = movie;
        this.content = content;
    }

    public Review() {

    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    
}
