package com.techelevator.controller;


import com.techelevator.dao.GenreDao;
import com.techelevator.dao.MovieDao;
import com.techelevator.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@CrossOrigin
public class GenreController {
    private final GenreDao genreDao;
    @Autowired
    public GenreController(GenreDao genre){
        this.genreDao = genre;
    }

    @RequestMapping( path = "/genres", method = RequestMethod.GET)
    public List<Genre> getGenres(){
        return genreDao.getAllGenres();
    }
    @RequestMapping( path = "/genre/{id}", method = RequestMethod.GET)
    public Genre getGenreById(@PathVariable int id){
        return genreDao.getGenreById(id);
    }

}
