package com.techelevator.dao;

import com.techelevator.model.Genre;
import com.techelevator.model.Movie;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class JdbcGenreDao implements GenreDao{
    public final JdbcTemplate jdbcTemplate;
    public JdbcGenreDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Genre> getAllGenres(){
        List<Genre> genres = new ArrayList<>();

        String sql = "SELECT * FROM genre;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            genres.add(mapRowToGenres(results));
        }
        return  genres;

    }
    @Override
    public Genre getGenreById(int id){
        Genre genre = null;

        String sql = "SELECT * FROM genre WHERE genre_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()){
            genre = mapRowToGenres(result);
        }
        return genre;
    }

    private Genre mapRowToGenres(SqlRowSet rs) {
        Genre genres = new Genre();
        genres.setGenreId(rs.getInt("genre_id"));
        genres.setName(rs.getString("genre_name"));

        return genres;
    }

}
