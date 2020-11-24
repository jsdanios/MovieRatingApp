package com.practice.MovieRatingApp.Controller;

import javax.validation.Valid;

import com.practice.MovieRatingApp.Model.Movie;
import com.practice.MovieRatingApp.Model.Review;
import com.practice.MovieRatingApp.Model.User;
import com.practice.MovieRatingApp.Service.ReviewService;
import com.practice.MovieRatingApp.Service.UserService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ReviewController {

    private ReviewService reviewService;
    private UserService userService;

    @GetMapping("/review")
    public String reviewForm(Movie movie, Model model) {
        //User user = userService.getLoggedInUser();
        // User user = new User();
        // String content = "";
        // model.addAttribute("review", new Review(user, movie, content));
        model.addAttribute("review", new Review());
        return "review";
    }

    @PostMapping("/review")
    public String reviewSubmit(@Valid Review review, BindingResult bindingResult, Model model) {
        //User user = userService.getLoggedInUser();
        if (!bindingResult.hasErrors()) {
            //review.setUser(user);
            reviewService.save(review);
            model.addAttribute("review", new Review());
            
        }
        return "movies";
    }
    
}
