package com.sda.spring.data.jpa.config;

import com.sda.spring.data.jpa.association.Father;
import com.sda.spring.data.jpa.association.FatherRepository;
import com.sda.spring.data.jpa.association.Son;
import com.sda.spring.data.jpa.association.SonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// de unde stie spring ca e un config?
//@Configuration
public class AppConfig {

    // de unde stie spring sa injecteze dependintele?

    @Autowired
    private SonRepository sonRepository;

    @Autowired
    private FatherRepository fatherRepository;

    @Bean
    public CommandLineRunner appData() {
        return args -> {
            saveFatherWithSons();
        };
    }

    private void saveFatherWithSons() {
        Son son1 = new Son();
        son1.setName("son1");

        Son son2 = new Son();
        son2.setName("son2");
//
//        sonRepository.save(son1);
//        sonRepository.save(son2);

        Father father = new Father();
        father.setName("father");
        father.getSons().add(son1);
        father.getSons().add(son2);

        fatherRepository.save(father);

        // create 2 sons
        // cine salveaza son => SonRepository
        // unde fac operatia de save?
        // cum salvez?
        // care son il salvez?

        // create father
        // cum fac legatura cu sons
        // save father
    }

}
