package com.sda.spring.boot.mvc.security.service;

import com.sda.spring.boot.mvc.security.model.AppUser;
import com.sda.spring.boot.mvc.security.model.AppUserPrincipal;
import com.sda.spring.boot.mvc.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AppUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Autowired
    public AppUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // get app user from db
        AppUser appUser = userRepository.findByUsername(username);

        if (appUser == null) {
            throw new UsernameNotFoundException(username);
        }

        // build app user principal from app user
        return new AppUserPrincipal(appUser);
    }
}
