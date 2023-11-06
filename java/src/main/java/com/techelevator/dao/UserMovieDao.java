package com.techelevator.dao;

import com.techelevator.model.Movie;
import com.techelevator.model.User;

import java.util.List;

public interface UserMovieDao {
    List<Movie> getUserWishList(String username);
    void addToWishList(int userId, int movieId);
    int deleteFromWishList(int movieId , int userId);
}
