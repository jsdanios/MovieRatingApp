package com.practice.MovieRatingApp.Repository;

import java.util.List;

import com.practice.MovieRatingApp.Model.Movie;
import com.practice.MovieRatingApp.Model.Review;
import com.practice.MovieRatingApp.Model.User;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Long> {

    List<Review> findByMovie(Movie movie);

    List<Review> findByUser(User user);
    
}
