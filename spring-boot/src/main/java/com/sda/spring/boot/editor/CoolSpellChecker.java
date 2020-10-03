package com.sda.spring.boot.editor;

import org.springframework.stereotype.Component;

@Component
public class CoolSpellChecker implements SpellChecker {

    @Override
    public String checkSpelling() {
        System.out.println("check spelling...");
        return "spell";
    }
}
