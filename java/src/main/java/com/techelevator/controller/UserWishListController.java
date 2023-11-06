package com.techelevator.controller;

import com.techelevator.dao.UserWishListDao;
import com.techelevator.model.Movie;
<<<<<<< HEAD:java/src/main/java/com/techelevator/controller/UserMovieController.java
import com.techelevator.model.User;
import com.techelevator.model.WishList;
import com.techelevator.services.WishlistService;
=======
>>>>>>> 6d077a4925d39a29033140d4f40361b573949fb5:java/src/main/java/com/techelevator/controller/UserWishListController.java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

<<<<<<< HEAD:java/src/main/java/com/techelevator/controller/UserMovieController.java
import javax.validation.Valid;
=======
>>>>>>> 6d077a4925d39a29033140d4f40361b573949fb5:java/src/main/java/com/techelevator/controller/UserWishListController.java
import java.security.Principal;
import java.util.List;

@RestController
@CrossOrigin
<<<<<<< HEAD:java/src/main/java/com/techelevator/controller/UserMovieController.java
public class UserMovieController {
    private final UserMovieDao userMovieDao;
    private final WishlistService wishlistService;

    @Autowired
    public UserMovieController(UserMovieDao userMovieDao, WishlistService wishlistService){
=======
public class UserWishListController {
    private final UserWishListDao userMovieDao;

    @Autowired
    public UserWishListController(UserWishListDao userMovieDao){
>>>>>>> 6d077a4925d39a29033140d4f40361b573949fb5:java/src/main/java/com/techelevator/controller/UserWishListController.java
        this.userMovieDao = userMovieDao;
        this.wishlistService = wishlistService;
    }

    @RequestMapping( path = "/wishlist", method = RequestMethod.GET)
<<<<<<< HEAD:java/src/main/java/com/techelevator/controller/UserMovieController.java
    public List<Movie> getUserWishlist(Principal principal){
        return userMovieDao.getUserWishList(principal.getName());
=======
    public List<Movie> getUserWishlist(Principal principal ){
        return userMovieDao.getUserWishList(principal);
>>>>>>> 6d077a4925d39a29033140d4f40361b573949fb5:java/src/main/java/com/techelevator/controller/UserWishListController.java
    }

    @ResponseStatus(HttpStatus.CREATED)
    @RequestMapping( path = "/movie/{id}/wishlist-add", method = RequestMethod.POST)
    public void addToWishlist(Principal principal,  @PathVariable int id){
        wishlistService.addToWishlist(principal.getName(), id);
    }

    @RequestMapping( path = "/movie/{id}/wishlist-delete", method = RequestMethod.DELETE)
<<<<<<< HEAD:java/src/main/java/com/techelevator/controller/UserMovieController.java
    public void deleteFromWishlist(@PathVariable int id, Principal principal){
        wishlistService.deleteFromWishList(principal.getName(), id);
=======
    public void deleteFromWishlist(@PathVariable int movieId,  int userId){
        userMovieDao.deleteFromWishList(movieId, userId);
>>>>>>> 6d077a4925d39a29033140d4f40361b573949fb5:java/src/main/java/com/techelevator/controller/UserWishListController.java
    }

}
