package com.techelevator.services;

import com.techelevator.dao.UserDao;
import com.techelevator.dao.UserMovieDao;
import com.techelevator.dao.UserWishListDao;
import com.techelevator.model.User;
import com.techelevator.model.WishList;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class UserWishListService {
    private final UserDao userDao;
    private final UserWishListDao userMovieDao;

    public UserWishListService(UserDao userDao, UserWishListDao userMovieDao){
        this.userDao = userDao;
        this.userMovieDao = userMovieDao;
    }

    public void deleteFromWishList(String username, int movieId){
        int userId = userDao.getUserIdByUsername(username);
        userMovieDao.deleteFromWishList(movieId, userId);
    }

    public void addToWishlist(String username, int movieId){
        int userId = userDao.getUserIdByUsername(username);
        userMovieDao.addToWishList(userId, movieId);
    }

//    private WishList mapRowToWishList(SqlRowSet rs) {
//        WishList wishList = new WishList();
//        wishList.setMovieId(rs.getInt("movie_id"));
//        wishList.setUserId(rs.getInt("user_id"));
//        return  wishList;
//    }


}