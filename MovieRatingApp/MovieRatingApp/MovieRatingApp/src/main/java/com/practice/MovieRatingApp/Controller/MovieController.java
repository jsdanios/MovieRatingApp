package com.practice.MovieRatingApp.Controller;

import com.practice.MovieRatingApp.Model.Movie;
import com.practice.MovieRatingApp.Service.MovieService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value = "/movie")
    public String movieForm(Model model) {
        model.addAttribute("movie", new Movie());
        return "movie";
    }

    @PostMapping(value = "/movie")
    public String movieSubmit(@ModelAttribute Movie movie, Model model) {
        model.addAttribute("movie", movie);
        movieService.save(movie);
        return "result";
    }

    @GetMapping(value = "/movies")
    public String showAll(Model model) {
        model.addAttribute("movies", movieService.findAll());
        return "movies";
    }

}
