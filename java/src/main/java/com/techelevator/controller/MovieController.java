package com.techelevator.controller;

import com.techelevator.dao.MovieDao;
import com.techelevator.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.annotation.HttpConstraint;
import javax.validation.Valid;
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

    @RequestMapping( path = "/movie/{id}", method = RequestMethod.GET)
    public Movie getMovieById(@PathVariable int id){
        return movieDao.getMovieById(id);
    }

    @RequestMapping( path = "/director/{id}/movies", method = RequestMethod.GET)
    public List<Movie> getMoviesByDirectorId(@PathVariable int id){
        return movieDao.getMoviesByDirectorId(id);
    }

    @RequestMapping( path = "/actor/{id}/movies", method = RequestMethod.GET)
    public List<Movie> getMoviesByActorId(@PathVariable int id){
        return movieDao.getMoviesByActorId(id);
    }
    @RequestMapping( path = "/genre/{id}/movies", method = RequestMethod.GET)
    public List<Movie> getMoviesByGenreId(@PathVariable int id){
        return movieDao.getMoviesByGenreId(id);
    }

    @RequestMapping( path = "/collection/{id}/movies", method = RequestMethod.GET)
    public List<Movie> getMoviesByCollectionId(@PathVariable int id){
        return movieDao.getMoviesByCollectionId(id);
    }
    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/add/movie", method = RequestMethod.POST)
    public Integer addMovie(@RequestBody @Valid Movie movie){
        return movieDao.addMovie(movie);
    }
}
