package com.bucur.recap.story.cosmina;

import com.bucur.recap.story.skills.Developer;
import com.bucur.recap.story.women.FinancialSecurity;
import com.bucur.recap.story.women.Love;
import com.bucur.recap.story.women.Woman;

public class Cosmina extends Woman implements Developer {

    public Cosmina(Love love, FinancialSecurity financialSecurity) {
        super(love, financialSecurity);
    }

    @Override
    public void feel() {
        System.out.println("feeling intense");
    }

    @Override
    public void dream() {
        System.out.println("become a programmer");
    }

    @Override
    public void relax() {
        System.out.println("watching a movie");
    }

    @Override
    public void develop() {
        System.out.println("read, write and repeat");
    }
}
