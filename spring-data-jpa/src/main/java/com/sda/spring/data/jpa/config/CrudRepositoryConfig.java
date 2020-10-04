package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.exception.NotFoundException;
import com.sda.spring.data.jpa.model.Person;
import com.sda.spring.data.jpa.repository.PersonCrudRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class CrudRepositoryConfig {

    private static final Logger logger = LoggerFactory.getLogger(CrudRepositoryConfig.class);

    @Autowired
    public PersonCrudRepository personCrudRepository;

    @Bean
    public CommandLineRunner crudData() {
        return args -> {
            testCrudMethods();
        };
    }

    private void testCrudMethods() {
        // save 2 people
        personCrudRepository.save(new Person("ana", 25));
        Person newPerson = new Person("paul", 30);
        personCrudRepository.save(newPerson);

        // read
//        Iterable<Person> people = personCrudRepository.findAll();
//        people.forEach(person -> System.out.println(person));

        personCrudRepository.findAll()
            .forEach(person -> logger.info("person: {}", person));

        boolean existsById = personCrudRepository.existsById(1L);
        logger.info("ana exists by id: {}", existsById);

        // update
        // not recommended
//        Optional<Person> paulOptional = personCrudRepository.findByName("paul");
//        if (paulOptional.isPresent()) {
//            Person paul = paulOptional.get();
//        }

        Person foundPerson = personCrudRepository.findByName("paul")
            .orElseThrow(() -> new NotFoundException("person not found"));

        // modify person
        foundPerson.setAge(50);

        // update in db
        Person updatedPerson = personCrudRepository.save(foundPerson);
        logger.info("updated person: {}", updatedPerson);

        // read from db

        // delete
        personCrudRepository.delete(updatedPerson);
    }

}
