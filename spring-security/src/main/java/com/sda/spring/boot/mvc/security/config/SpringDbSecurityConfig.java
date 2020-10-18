package com.sda.spring.boot.mvc.security.config;

import com.sda.spring.boot.mvc.security.service.AppUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@Configuration
//@EnableWebSecurity
public class SpringDbSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public AppUserDetailsService appUserDetailsService;

    // use custom implementation
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(appUserDetailsService)
            .passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
            .authorizeRequests()

            // allow access to h2 console
            .antMatchers("/h2-console/**").permitAll()

            // allow access to login page
            .antMatchers("/login").permitAll()

            // permit access to console
            // protect all other resources
            .anyRequest().authenticated()
            .and()

            // use spring security default login page
            .formLogin().permitAll()
            .and()

            // enable h2 console frames
            .headers().frameOptions().sameOrigin()
            .and()
            .logout().permitAll();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
