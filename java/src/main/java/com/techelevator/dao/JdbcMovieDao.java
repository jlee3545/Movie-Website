package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Genre;
import com.techelevator.model.Movie;
import com.techelevator.model.Person;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcMovieDao implements MovieDao {

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

    public List<Movie> getMoviesByDirectorId(Person id){
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie WHERE director_id =?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);

        while(results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    public List<Movie> getMoviesByActorId(Person id){
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie " +
                "JOIN movie_actor ON movie.movie_id = movie_actor.movie_id " +
                "WHERE actor_id=?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);

        while(results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    public List<Movie> getMoviesByGenreId(Genre id){
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie " +
                "JOIN movie_genre ON movie.movie_id = movie_genre.movie_id " +
                "WHERE genre_id=?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);

        while(results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    public List<Movie> getMoviesByCollectionId(Collection id){
        List<Movie> movies = new ArrayList<>();
        String sql = "SELECT * FROM movie " +
                "WHERE collection_id=?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql,id);

        while(results.next()){
            movies.add(mapRowToMovie(results));
        }
        return movies;
    }

    public Integer addMovie(Movie movie){
        String sql = "INSERT INTO movie (title, overview, poster_path, release_date, length_minutes, director_id, collection_id) " +
                "VALUES(?,?,?,?,?,?,?) RETURNING movie_id";

        Integer id =0;
        try {
            id = jdbcTemplate.queryForObject(sql, Integer.class, movie.getTitle(), movie.getOverview(), movie.getPosterPath(), movie.getReleaseDate(), movie.getLength(), movie.getDirectorId(), movie.getCollectionId());
        } catch (DataAccessException e){
            throw new DataAccessException(e.toString()) {};
        }
        return id;
    }
    public void updateMovie(Movie movie){

        String sql = "UPDATE movie " +
                "SET title =?, overview = ?, poster_path =?, release_date =?, " +
                "length_minutes =?, director_id =?, collection_id=? " +
                "WHERE movie_id = ?";
        try {
            jdbcTemplate.update(sql,movie.getTitle(), movie.getOverview(), movie.getPosterPath(), movie.getReleaseDate(), movie.getLength(), movie.getDirectorId(), movie.getCollectionId(), movie.getMovieId());

        } catch (DataAccessException e) {
            throw new DataAccessException("Error Updating") {
            };
        }
    }
//    public int deleteMovie(Movie id){
//        String sql = "UPDATE movie " +
//                "SET title =?, overview = ?, poster_path =?, release_date =?, " +
//                "length_minutes =?, director_id =?, collection_id=? " +
//                "WHERE movie_id = ?";
//        try {
//            jdbcTemplate.update(sql, movie.getMovieId());
//
//        } catch (DataAccessException e) {
//            throw new DataAccessException("Error Updating") {
//            };
//        }
//    }



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
