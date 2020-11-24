package com.practice.MovieRatingApp.Controller;

import com.practice.MovieRatingApp.Model.Movie;
import com.practice.MovieRatingApp.Model.User;
import com.practice.MovieRatingApp.Service.MovieService;
import com.practice.MovieRatingApp.Service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MovieService movieService;

    //see https://github.com/chenjy0801/voting-system, https://github.com/JolaPsh/voting-system
    
    @GetMapping(value = "/voteup")
    public ResponseEntity<Object> voteUp(@RequestParam String name) {
        // User user = userService.getLoggedInUser();
        Movie movie = movieService.findByName(name);
        movieService.updateRatingUp(movie);
        // if (user != null) {
        //     if (!user.getVotedUp().contains(movie)) {
        //         movieService.updateRatingUp(movie);
        //         user.getVotedUp().add(movie);
        //         if (user.getVotedDown().contains(movie)) {
        //             movieService.updateRatingUp(movie);
        //             user.getVotedDown().remove(movie);
        //         }
        //     }
        // }
        return new ResponseEntity<>("Vote successful", HttpStatus.OK);
    }

    @RequestMapping("/votedown")
    public String voteDown(@RequestParam String name) {
        User user = userService.getLoggedInUser();
        Movie movie = movieService.findByName(name);
        if (user != null) {
            if (!user.getVotedDown().contains(movie)) {
                movieService.voteDown(movie);
                user.getVotedDown().add(movie);
                if (user.getVotedUp().contains(movie)) {
                    movieService.voteDown(movie);
                    user.getVotedUp().remove(movie);
                }
            }
        }
        return "redirect:/movies";
    }
    
}
