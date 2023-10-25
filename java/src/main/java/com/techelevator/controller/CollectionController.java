package com.techelevator.controller;

import com.techelevator.dao.CollectionDao;
import com.techelevator.model.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CollectionController {
    private final CollectionDao collectionDao;

    @Autowired
    public CollectionController(CollectionDao collectionDao){
        this.collectionDao = collectionDao;
    }

    @RequestMapping( path = "/collections", method = RequestMethod.GET)
    public List<Collection> getAllCollections(){
        return collectionDao.getAllCollections();
    }

    @RequestMapping( path = "/collection/{id}", method = RequestMethod.GET)
    public Collection getCollectionById(@PathVariable int id){
        return collectionDao.getCollectionById(id);
    }
}
