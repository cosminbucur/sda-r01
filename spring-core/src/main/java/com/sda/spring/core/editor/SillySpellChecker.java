package com.sda.spring.core.editor;

public class SillySpellChecker implements SpellChecker {

    @Override
    public String checkSpelling() {
        System.out.println("check spelling...");
        return "bla bla";
    }
}
