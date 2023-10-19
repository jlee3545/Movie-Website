package com.techelevator.controller;

import com.techelevator.dao.MovieDao;
import com.techelevator.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class MovieController {
    private final MovieDao movieDao;
    @Autowired
    public MovieController(MovieDao movie){
        this.movieDao = movie;
    }
    @RequestMapping( path = "/movies", method = RequestMethod.GET)
    public List<Movie> getMovies(){
        return movieDao.getAllMovies();
    }
}
