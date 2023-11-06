package com.techelevator.dao;

import com.techelevator.model.Movie;

import java.util.List;

<<<<<<< HEAD:java/src/main/java/com/techelevator/dao/UserMovieDao.java
public interface UserMovieDao {
    List<Movie> getUserWishList(String username);
=======
public interface UserWishListDao {
    List<Movie> getUserWishList();
>>>>>>> 6d077a4925d39a29033140d4f40361b573949fb5:java/src/main/java/com/techelevator/dao/UserWishListDao.java
    void addToWishList(int userId, int movieId);
    int deleteFromWishList(int movieId , int userId);
}
