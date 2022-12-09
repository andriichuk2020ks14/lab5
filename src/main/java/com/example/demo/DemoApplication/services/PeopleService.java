package com.example.demo.DemoApplication.services;

import com.example.demo.DemoApplication.models.Person;
import com.example.demo.DemoApplication.repositories.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class PeopleService {

    public final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public Optional<Person> findByUsername(String string){
        return peopleRepository.findByUsername(string);
    }

}
