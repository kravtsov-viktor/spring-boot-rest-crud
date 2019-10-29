package com.example.demo.repository;


import com.example.demo.entity.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonRepository {

    private List<Person> persons = new ArrayList<>();

    { // инициализатор класса - заполянем репозиторий начальными данными
        persons.add(new Person(0, "ivanov", 11));
        persons.add(new Person(1, "petrov", 22));
        persons.add(new Person(2, "sidorov", 33));
        persons.add(new Person(3, "stogov", 44));
    }


    public List<Person> findAll() {
        return new ArrayList<>(persons);
    }


    public Person findById(int id) {
        return persons.stream()
                .filter(c -> c.getId() == id)
                .findFirst().orElse(null);
    }


    public boolean deleteById(int id) {
        return persons.removeIf(e -> e.getId() == id);
    }


    public void update(Person p) {
        persons.removeIf(e -> e.getId() == p.getId());
        persons.add(p);
    }


    public void save(Person p) {
        persons.add(p);
    }

}