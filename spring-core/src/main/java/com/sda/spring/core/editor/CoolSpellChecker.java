package com.sda.spring.core.editor;

public class CoolSpellChecker implements SpellChecker {

    @Override
    public String checkSpelling() {
        System.out.println("check spelling...");
        return "spell";
    }
}
