package com.sda.spring.mvc.hibernate.repository;

import com.sda.spring.mvc.hibernate.model.User;

import java.util.List;

public interface UserDao {

    User findOne(long id);

    List<User> findAll();

    void create(User user);

    User update(User user);

    void delete(User user);

    void deleteById(long id);
}
