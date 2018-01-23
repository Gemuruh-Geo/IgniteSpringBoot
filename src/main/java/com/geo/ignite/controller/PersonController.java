package com.geo.ignite.controller;

import com.geo.ignite.model.Person;
import com.geo.ignite.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person/{id}",method = RequestMethod.GET)
    public Person testUpdate(@PathVariable Long id){
        Person person = personService.tesUpdate(id);
        return person;
    }

    @RequestMapping(value = "/persons",method = RequestMethod.GET)
    public List<Person> getAllPerson(){
        return personService.getAllPerson();
    }


}
