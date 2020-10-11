package com.sda.spring.mvc.service;

import com.sda.spring.mvc.repository.UserRepository;
import com.sda.spring.mvc.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // get users from database
    public List<User> findAll() {
        // convert user to dto
        System.out.println("in find all");
        return userRepository.findAll();
    }

    public void save(User user) {
        System.out.println("in save");
//        userRepository.save(user);
    }
}
