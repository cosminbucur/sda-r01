package com.sda.spring.data.jpa.repository;

import com.sda.spring.data.jpa.model.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PersonCrudRepository extends CrudRepository<Person, Long> {

    // derivated query
    // SELECT * FROM person p WHERE p.name = :name
    Optional<Person> findByName(String name);
}
