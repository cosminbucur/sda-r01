package com.sda.spring.data.jpa.service;

import com.sda.spring.data.jpa.config.CrudRepositoryConfig;
import com.sda.spring.data.jpa.exception.NotFoundException;
import com.sda.spring.data.jpa.model.User;
import com.sda.spring.data.jpa.model.UserDto;
import com.sda.spring.data.jpa.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// contains business logic and validations
@Service
public class UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        // TODO: validate input
        userRepository.save(user);
    }

    public List<User> findAll() {
        // search all users in db
        return (List<User>) userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        // find user from db
        return userRepository.findById(id);
    }

    // TODO: implement this
    public List<UserDto> findAllNamesAndEmails() {
        // find all users
        Iterable<User> foundUsers = userRepository.findAll();

        // convert each user to user dto

        // return all user dtos
        return null;
    }

    // TODO: extract this in an mapper object
    // convert users to user dtos
    private List<UserDto> toDto(List<User> users) {
        List<UserDto> result = new ArrayList<>();
        users.forEach(user -> {
            UserDto userDto = toDto(user);
            result.add(userDto);
        });
        return result;
    }

    // convert one user to a user dto
    private UserDto toDto(User user) {
        UserDto result = new UserDto();
        result.setId(user.getId());
        result.setName(user.getName());
        result.setEmail(user.getEmail());
        return result;
    }

    public void update(Long id, User userData) {
        // validate data
        if ("".equals(userData.getEmail())) {
            logger.warn("invalid email");
        }

        // find user to be updated from db
        User foundUser = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("user not found"));

        if (foundUser != null) {
            // make changes
            foundUser.setName(userData.getName());
            foundUser.setAge(userData.getAge());
            foundUser.setEmail(userData.getEmail());
            foundUser.setConsent(userData.isConsent());
            foundUser.setAboutMe(userData.getAboutMe());

            // save the updated user
            userRepository.save(foundUser);
        } else {
            logger.error("user not updated");
        }

    }

    public void delete(Long id) {
        // what if this id doesnt exist?
        User foundUser = userRepository.findById(id)
            .orElseThrow(() -> new NotFoundException("user not found"));

        // fail fast
        if (foundUser == null) {
            logger.error("user not deleted");
        } else {
            userRepository.deleteById(id);
        }
    }
}
