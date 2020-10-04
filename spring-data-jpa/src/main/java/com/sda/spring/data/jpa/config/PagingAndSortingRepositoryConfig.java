package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.model.Person;
import com.sda.spring.data.jpa.repository.PersonPagingAndSortingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

//@Configuration
public class PagingAndSortingRepositoryConfig {

    private static final Logger logger = LoggerFactory.getLogger(PagingAndSortingRepositoryConfig.class);

    @Autowired
    private PersonPagingAndSortingRepository repository;

    @Bean
    public CommandLineRunner pagingData() {
        return args -> {
            loadData();
            paginate();
            sort();
            paginateAndSort();
        };
    }

    // load data
    private void loadData() {
        logger.info("loading data...");
        // save people in db
        // page 1
        repository.save(new Person("paul", 32));
        repository.save(new Person("alina", 28));
        // page 2
        repository.save(new Person("kazimir", 34));
        repository.save(new Person("lidia", 32));
        // page 3
        repository.save(new Person("violeta", 32));
    }

    private void paginate() {
        logger.info("paginating...");
        // interface pageable - pagination info
        // abstract page request - abstract class
        // page request - implementation class
        Pageable firstPageWithTwoElements = PageRequest.of(0, 2);

        Page<Person> page = repository.findAll(firstPageWithTwoElements);
        printPageContent(page.getContent());
    }

    private void sort() {
        logger.info("sorting...");
        Sort sortByName = Sort.by("name");
        Iterable<Person> sortedPeople = repository.findAll(sortByName);

        printPageContent(sortedPeople);
    }

    private void paginateAndSort() {
        Pageable sortedByName = PageRequest.of(0, 5, Sort.by("name"));
        Pageable sortedByAgeDescending = PageRequest.of(0, 4, Sort.by("age").descending());
        Pageable sortedByAgeDescendingAndNameAscending =
            PageRequest.of(0, 5,
                Sort.by("age").descending()
                    .and(Sort.by("name").ascending()));

        logger.info("sort by name");
        Page<Person> peopleSortedByName = repository.findAll(sortedByName);
        logger.info("sort by age");
        Page<Person> peopleSortedByAgeDescending = repository.findAll(sortedByAgeDescending);
        logger.info("sort by age and name");
        Page<Person> peopleSortedByAgeDescendingAndNameAscending = repository.findAll(sortedByAgeDescendingAndNameAscending);

        printPageContent(peopleSortedByName);
        printPageContent(peopleSortedByAgeDescending);
        printPageContent(peopleSortedByAgeDescendingAndNameAscending);
    }

    private void printPageContent(Iterable<Person> people) {
        people.forEach(person -> logger.info("person: {}", person));
    }
}
