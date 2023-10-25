package com.techelevator.controller;


import com.techelevator.dao.PersonDao;
import com.techelevator.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PersonController {
    private final PersonDao personDao;
    @Autowired
    public PersonController(PersonDao person){
        this.personDao = person;
    }
    @RequestMapping( path = "/movies/{id}/actors", method = RequestMethod.GET)
    public List<Person> getActorsFromMovie(@PathVariable int id){
        return personDao.getAllActorsFromMovie(id);
    }
    @RequestMapping( path = "/person/{id}", method = RequestMethod.GET)
    public Person getPersonById(@PathVariable int id){
        return personDao.getPersonById(id);
    }
    @RequestMapping( path = "/director/{id}", method = RequestMethod.GET)
    public Person getPersonByDirectorId(@PathVariable int id){
        return personDao.getPersonByDirectorId(id);
    }
    @RequestMapping( path = "/actor/{id}", method = RequestMethod.GET)
    public Person getPersonByActorId(@PathVariable int id){
        return personDao.getPersonByActorId(id);
    }
}
