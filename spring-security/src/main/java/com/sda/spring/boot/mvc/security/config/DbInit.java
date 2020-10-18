package com.sda.spring.boot.mvc.security.config;

import com.sda.spring.boot.mvc.security.model.AppUser;
import com.sda.spring.boot.mvc.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class DbInit implements CommandLineRunner {

    @Autowired
    public UserRepository userRepository;

    @Override
    public void run(String... args) {
        // save an initial admin user in order to log in
        AppUser appUser = new AppUser("admin", "pass", "ADMIN", "ACCESS_MOBILE, ACCESS_WEB");
        userRepository.save(appUser);
    }
}
