package com.practice.MovieRatingApp.Service;

import java.util.List;

import com.practice.MovieRatingApp.Model.Movie;
import com.practice.MovieRatingApp.Model.Review;
import com.practice.MovieRatingApp.Model.User;
import com.practice.MovieRatingApp.Repository.ReviewRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository;

    public List<Review> findByMovie(Movie movie) {
        return reviewRepository.findByMovie(movie);
    }

    public List<Review> findByUsere(User user) {
        return reviewRepository.findByUser(user);
    }

    public void save(Review review) {
        reviewRepository.save(review);
    }
    
}
