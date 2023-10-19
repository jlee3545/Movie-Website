package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Genre;
import com.techelevator.model.Movie;
import com.techelevator.model.Person;

import java.util.List;

public interface MovieDao {
    List<Movie> getAllMovies();
    Movie getMovieById(int id);
    List<Movie> getMoviesByDirectorId(int id);
    List<Movie> getMoviesByActorId(int id);
    List<Movie> getMoviesByGenreId(int id);
    List<Movie> getMoviesByCollectionId(int id);
    Integer addMovie(Movie movie);
    void updateMovie(Movie movie);
//    int deleteMovie(Movie id);
}
