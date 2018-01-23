package com.geo.ignite.service;

import com.geo.ignite.igniteRepository.PersonRepository;
import com.geo.ignite.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;


@Component
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @PostConstruct
    public void initPerson(){

        TreeMap<Long,Person> persons = new TreeMap<>();

        persons.put(1L, new Person(1L, 2000L, "John", "Smith", 15000, "Worked for Apple"));
        persons.put(2L, new Person(2L, 2000L, "Brad", "Pitt", 16000, "Worked for Oracle"));
        persons.put(3L, new Person(3L, 1000L, "Mark", "Tomson", 10000, "Worked for Sun"));
        persons.put(4L, new Person(4L, 2000L, "Erick", "Smith", 13000, "Worked for Apple"));
        persons.put(5L, new Person(5L, 1000L, "John", "Rozenberg", 25000, "Worked for RedHat"));
        persons.put(6L, new Person(6L, 2000L, "Denis", "Won", 35000, "Worked for CBS"));
        persons.put(7L, new Person(7L, 1000L, "Abdula", "Adis", 45000, "Worked for NBC"));
        persons.put(8L, new Person(8L, 2000L, "Roman", "Ive", 15000, "Worked for Sun"));


        personRepository.save(persons);


    }

    public List<Person> getAllPerson(){
        Iterable<Person> res = personRepository.findAll();
        List<Person> arrayList = new ArrayList<>();
        res.forEach(p->{
            arrayList.add(p);
        });
        return arrayList;
    }
    public Person tesUpdate(Long id){
        Person person = personRepository.findById(id);
        person.setFirstName("Budi");
        return personRepository.save(id,person);
    }
}
