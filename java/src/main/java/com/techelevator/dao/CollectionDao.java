package com.techelevator.dao;

import com.techelevator.model.Collection;

import java.util.List;

public interface CollectionDao {
    List<Collection> getAllCollections();
    Collection getCollectionById(int id);
}
