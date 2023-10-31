package com.techelevator.controller;

import com.techelevator.dao.MovieDao;
import com.techelevator.dao.UserMovieDao;
import com.techelevator.model.Movie;
import com.techelevator.model.User;
import com.techelevator.model.WishList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
public class UserMovieController {
    private final UserMovieDao userMovieDao;

    @Autowired
    public UserMovieController(UserMovieDao userMovieDao){
        this.userMovieDao = userMovieDao;
    }

    @RequestMapping( path = "/wishlist", method = RequestMethod.GET)
    public List<Movie> getUserWishlist(int id){
        return userMovieDao.getUserWishList(id);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/movie/{id}/wishlist-add", method = RequestMethod.POST)
    public void addToWishlist(int userId,  @PathVariable int movieId){
        userMovieDao.addToWishList(userId, movieId);
    }

    @RequestMapping( path = "/movie/{id}/wishlist-delete", method = RequestMethod.DELETE)
    public void deleteFromWishlist(@PathVariable int movieId,  int userId){
        userMovieDao.addToWishList(movieId, userId);
    }

}
