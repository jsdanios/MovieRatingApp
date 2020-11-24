package com.practice.MovieRatingApp.Service;

import java.util.List;

import com.practice.MovieRatingApp.Model.Movie;
import com.practice.MovieRatingApp.Repository.MovieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepository;

    public List<Movie> findAll() {
        List<Movie> movieList = movieRepository.findAll();
        return movieList;
    }

    public void save(Movie movie) {
        movieRepository.save(movie);
    }

    public void updateRatingUp(Movie movie) {
        voteUp(movie);
    }

    public void voteUp(Movie movie) {
        movie.setRating(movie.getRating() + 1);
    }

    public void voteDown(Movie movie) {
        movie.setRating(movie.getRating() - 1);
    }

    public Movie findByName(String name) {
        return movieRepository.findByName(name);
    }
    
}
