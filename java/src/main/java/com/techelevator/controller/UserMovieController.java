package com.techelevator.controller;

import com.techelevator.dao.MovieDao;
import com.techelevator.dao.UserMovieDao;
import com.techelevator.model.Movie;
import com.techelevator.model.User;
import com.techelevator.model.WishList;
import com.techelevator.services.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
public class UserMovieController {
    private final UserMovieDao userMovieDao;
    private final WishlistService wishlistService;

    @Autowired
    public UserMovieController(UserMovieDao userMovieDao, WishlistService wishlistService){
        this.userMovieDao = userMovieDao;
        this.wishlistService = wishlistService;
    }

    @RequestMapping( path = "/wishlist", method = RequestMethod.GET)
    public List<Movie> getUserWishlist(Principal principal){
        return userMovieDao.getUserWishList(principal.getName());
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/movie/{id}/wishlist-add", method = RequestMethod.POST)
    public void addToWishlist(Principal principal,  @PathVariable int id){
        wishlistService.addToWishlist(principal.getName(), id);
    }

    @RequestMapping( path = "/movie/{id}/wishlist-delete", method = RequestMethod.DELETE)
    public void deleteFromWishlist(@PathVariable int id, Principal principal){
        wishlistService.deleteFromWishList(principal.getName(), id);
    }

}
