package com.techelevator.dao;

import com.techelevator.model.*;

import java.util.List;

public interface MovieDao {
    List<Movie> getAllMovies();
    Movie getMovieById(int id);
    List<Movie> getMoviesByDirectorId(Person id);
    List<Movie> getMoviesByActorId(Person id);
    List<Movie> getMoviesByGenreId(Genre id);
    List<Movie> getMoviesByCollectionId(Collection id);
    Integer addMovie(Movie movie);
    void updateMovie(Movie movie);
//    int deleteMovie(Movie id);
}
