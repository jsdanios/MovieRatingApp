package com.practice.MovieRatingApp.Repository;

import java.util.List;

import com.practice.MovieRatingApp.Model.Movie;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    List<Movie> findAll();

    Movie findByName(String name);
}
