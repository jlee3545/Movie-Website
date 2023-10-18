package com.techelevator.dao;

import com.techelevator.model.Movie;
import com.techelevator.model.User;

import java.util.List;

public interface UserMovieDao {
    List<Movie> getUserWishList(int id);
    List<Movie> addToWishList(User user, Movie movie);
    int deleteFromWishList(Movie movieId , User userId);
}
