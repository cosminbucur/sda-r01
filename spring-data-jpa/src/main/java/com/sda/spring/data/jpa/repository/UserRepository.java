package com.sda.spring.data.jpa.repository;

import com.sda.spring.data.jpa.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// interacts with the db (creates queries)
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
