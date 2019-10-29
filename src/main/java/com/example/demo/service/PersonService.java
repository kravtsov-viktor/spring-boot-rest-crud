package com.example.demo.service;

import com.example.demo.entity.Person;
import com.example.demo.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;


    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }


    public List<Person> search(String name) {
        return personRepository.findAll().stream()
                .filter(c -> c.getName().contains(name))
                .collect(Collectors.toList());
    }


    public Person getPersonById(int id) {
        return personRepository.findById(id);
    }


    public void updatePerson(Person person) {
        personRepository.update(person);
    }


    public void addPerson(Person person) {
        personRepository.save(person);
    }


    public boolean deletePerson(int id) {
        return personRepository.deleteById(id);
    }
} 