package com.sda.spring.boot.mvc.security.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// create an in memory authentication configuration
//@EnableWebSecurity
public class SpringInMemorySecurityConfig extends WebSecurityConfigurerAdapter {

    // who are you?
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()

            // define user with roles / authorities
            // admin user
            .withUser("admin")
            .password("{noop}pass")
            .roles("ADMIN")

            // regular user
            .and()
            .withUser("user")
            .password("{noop}pass")
            .roles("USER")
        ;
    }

    // what are you allowed to do?
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // allow admin and user to access any request
        http.authorizeRequests().anyRequest().hasAnyRole("ADMIN", "USER")
            .and()
            .httpBasic();   // use basic authentication
    }
}
