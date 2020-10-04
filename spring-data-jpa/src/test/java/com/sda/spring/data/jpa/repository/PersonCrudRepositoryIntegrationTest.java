package com.sda.spring.data.jpa.repository;

import com.sda.spring.data.jpa.model.Person;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class PersonCrudRepositoryIntegrationTest {

    @Autowired
    private PersonCrudRepository personCrudRepository;

    @Test
    void givenTwoPeople_whenFindByName_thenReturnCorrectPerson() {
        // given
        personCrudRepository.save(new Person("ana", 25));
        String expected = "paul";
        personCrudRepository.save(new Person(expected, 30));

        // when
        Person paul = personCrudRepository.findByName(expected)
            .orElseThrow(() -> new RuntimeException());

        // then
        assertThat(paul.getName()).isEqualTo(expected);
    }

    @Test
    void givenTwoPeople_whenDelete_thenOk() {
        // count people before delete
        // delete
        // count people after delete
        // if before > after
    }
}