package com.techelevator.dao;

import com.techelevator.model.Movie;
import com.techelevator.model.User;
import com.techelevator.model.WishList;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcUserMovieDao implements UserMovieDao {

    public final JdbcTemplate jdbcTemplate;
    public JdbcUserMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Movie> getUserWishList(int id){
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie " +
                "JOIN users_movies ON movie.movie_id = users_movies.movie_id " +
                "WHERE user_id =?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        while(results.next()){
            movies.add(mapRowToMovie(results));
        }

        return movies;
    }
    @Override
    public List<Movie> addToWishList(User user, Movie movie){
        List <Movie> movies = new ArrayList<>();

        String sql = "INSERT INTO users_movies (user_id, movie_id) VALUES(?,?)";

//        try {
            jdbcTemplate.queryForRowSet(sql, user.getId(), movie.getMovieId());
//        } catch (DataAccessException e){
//            throw new DataAccessException(e.toString()) {};
//        }
        return movies;
    }
    @Override
    public int deleteFromWishList(Movie movieId , User userId){
        String sql = "DELETE FROM users_movies WHERE movie_id = ? AND user_id = ?";
        int row =0;
        try{
            row = jdbcTemplate.update(sql, movieId, userId);
        } catch (DataAccessException e) {
            throw new DataAccessException(e.toString()) {
            };
        }
        return row;
    }

    private Movie mapRowToMovie(SqlRowSet rs) {
        Movie movie = new Movie();
        movie.setMovieId(rs.getInt("movie_id"));
        movie.setDirectorId(rs.getInt("director_id"));
        movie.setTitle(rs.getString("title"));
        movie.setPosterPath(rs.getString("poster_path"));
        movie.setOverview(rs.getString("overview"));
        movie.setReleaseDate(rs.getString("release_date"));
        movie.setLength(rs.getInt("length_minutes"));
        movie.setCollectionId(rs.getInt("collection_id"));

        return movie;
    }
}
