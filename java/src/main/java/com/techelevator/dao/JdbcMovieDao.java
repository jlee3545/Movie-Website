package com.techelevator.dao;

import com.techelevator.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao {

    public final JdbcTemplate jdbcTemplate;
    public JdbcMovieDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Movie> getAllMovies(){
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            movies.add(mapRowToMovie(results));
        }
        return  movies;
    }

    public Movie getMovieById(int id){
        Movie movie = new Movie();
        String sql = "SELECT * FROM movie WHERE movie_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()){
            movie = mapRowToMovie(result);
        }
        return movie;
    }

    public List<Movie> getMoviesByDirectorId(int id){
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie WHERE director_id =?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);

        while(results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
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
