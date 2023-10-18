package com.techelevator.dao;

import com.techelevator.model.Collection;
import com.techelevator.model.Genre;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import java.util.ArrayList;
import java.util.List;

public class JdbcCollectionDao implements CollectionDao {
    public final JdbcTemplate jdbcTemplate;
    public JdbcCollectionDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Collection> getAllCollections(){
        List<Collection> collections = new ArrayList<>();

        String sql = "SELECT * FROM collection;";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sql);

        while(results.next()){
            collections.add(mapRowToCollection(results));
        }
        return collections;
    }

    @Override
    public Collection getCollectionById(int id) {
        Collection collections = null;

        String sql = "SELECT * FROM collection WHERE collection_id = ?";

        SqlRowSet result = jdbcTemplate.queryForRowSet(sql, id);

        if(result.next()){
            collections = mapRowToCollection(result);
        }
        return collections;
    }

    private Collection mapRowToCollection(SqlRowSet rs) {
        Collection collections = new Collection();
        collections.setCollectionId(rs.getInt("collection_id"));
        collections.setName(rs.getString("collection_name"));

        return collections;
    }
}
