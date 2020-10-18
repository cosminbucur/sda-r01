package com.sda.spring.boot.mvc.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

// create an in memory authentication configuration
@EnableWebSecurity
@Configuration
public class SpringInMemorySecurityWithEncoderConfig extends WebSecurityConfigurerAdapter {

    // who are you?
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()

            // role (name)

            // authority (ROLE_name , permission)

            // define user with roles / authorities
            // admin user
            .withUser("admin")
            .password(passwordEncoder().encode("pass"))
            .authorities("ROLE_ADMIN", "ACCESS_MOBILE", "ACCESS_WEB")

            // regular user
            .and()
            .withUser("user")
            .password(passwordEncoder().encode("pass"))
            .roles("USER")

            // manager user
            .and()
            .withUser("manager")
            .password(passwordEncoder().encode("pass"))
            .authorities("ROLE_MANAGER", "ACCESS_MOBILE");
    }

    // what are you allowed to do?
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            // restrict from granular to general
            .antMatchers("/admin/**").hasRole("ADMIN")
            .antMatchers("/user/**").hasAnyRole("USER", "ADMIN")
            .antMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
            .antMatchers("/home").permitAll()

            // public access
            .antMatchers("/api/public/mobile").permitAll()
            .antMatchers("/api/public/webapp").permitAll()

//            .anyRequest().authenticated()
            .and()
            .httpBasic();   // use basic authentication
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
