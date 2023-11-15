package com.techelevator.controller;

import com.techelevator.dao.UserWishListDao;
import com.techelevator.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class UserWishListController {
    private final UserWishListDao userMovieDao;

    @Autowired
    public UserWishListController(UserWishListDao userMovieDao){
        this.userMovieDao = userMovieDao;
    }

    @RequestMapping( path = "/wishlist", method = RequestMethod.GET)
    public List<Movie> getUserWishlist(Principal principal ){
        return userMovieDao.getUserWishList(principal.getName());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/movie/{id}/wishlist-add", method = RequestMethod.POST)
    public void addToWishlist(Principal principal  @PathVariable int movieId){
        userMovieDao.addToWishList(userId, movieId);
    }

    @RequestMapping( path = "/movie/{id}/wishlist-delete", method = RequestMethod.DELETE)
    public void deleteFromWishlist(@PathVariable int movieId,  int userId){
        userMovieDao.deleteFromWishList(movieId, userId);
    }

}
