package com.sda.spring.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    // define beans to be used in the application

    // metadata
    // method name = the name of the bean
    @Bean
    public MyBean myBean() {
        return new MyBean();
    }
}
