package com.practice.MovieRatingApp.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String year;
    private String director;
    private String image;

    private int rating = 0;

    public Movie() {
        super();
    }

    public Movie(Long id, String name, String year, String director, String image, int rating) {
        super();
        this.id = id;
        this.name = name;
        this.year = year;
        this.director = director;
        this.rating = rating;
        this.image = image;
    }

    public Movie(String name, String year, String director, String image, int rating) {
        super();
        this.name = name;
        this.year = year;
        this.director = director;
        this.image = image;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

}
