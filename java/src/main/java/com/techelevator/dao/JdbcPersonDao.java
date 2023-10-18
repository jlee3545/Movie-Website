package com.techelevator.dao;

import com.techelevator.model.Movie;
import com.techelevator.model.Person;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcPersonDao implements PersonDao {
    public final JdbcTemplate jdbcTemplate;
    public JdbcPersonDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    public List<Person> getAllActorsFromMovie(Movie id){
        List<Person> actors = new ArrayList<>();
        String sql="SELECT * FROM person " +
                "JOIN movie_actor ON movie_actor.actor_id = person.actor_id " +
                "WHERE movie_id = ?";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql, id);

        while(results.next()){
            actors.add(mapRowToPerson(results));
        }
        return actors;
    }

    public Person getPersonById(int id){
        Person person = null;
        String sql = "SELECT * FROM person " +
                "WHERE person_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()){
            person = mapRowToPerson(result);
        }
        return person;
    }

    @Override
    public Person getPersonByDirectorId(int id) {
        Person person = null;
        String sql = "SELECT * FROM person " +
                "JOIN movie ON person.person_id = movie.director_id " +
                "WHERE director_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()){
            person = mapRowToPerson(result);
        }
        return person;
    }

    @Override
    public Person getPersonByActorId(int id) {
        Person person = null;
        String sql = "SELECT * FROM person " +
                "JOIN movie_actor ON person.person_id = movie_actor.actor_id" +
                "WHERE actor_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()){
            person = mapRowToPerson(result);
        }
        return person;
    }


    private Person mapRowToPerson(SqlRowSet rs) {
        Person person = new Person();
        person.setPersonId(rs.getInt("person_id"));
        person.setName(rs.getString("person_name"));
        person.setBirthday(rs.getString("birthday"));
        person.setDeathday(rs.getString("deathday"));
        person.setBiography(rs.getString("biography"));
        person.setPhoto(rs.getString("profile_path"));

        return person;
    }
}
