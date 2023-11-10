package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

public interface UserMovieDao {
    List<Movie> getUserWishList(String username);
=======
public interface UserWishListDao {
    List<Movie> getUserWishList();
    void addToWishList(int userId, int movieId);
    int deleteFromWishList(int movieId , int userId);
}
