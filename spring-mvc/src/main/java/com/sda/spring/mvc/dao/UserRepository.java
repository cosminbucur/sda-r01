package com.sda.spring.mvc.dao;

import com.sda.spring.mvc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {

    @Autowired
    private SessionFactory sessionFactory;

    // get users from db
    public List<User> findAll() {
        // open session
        Query<User> query;
        try (Session session = sessionFactory.openSession()) {
            // create query using HQL
            query = session.createQuery("from User", User.class);
        }

        // execute
        return query.getResultList();
    }
}
