package com.bucur.recap.access_modifiers.home;

public class Thief {

    public void hasAccessTo() {

        // class name - object name = call constructor
        Parent parent = new Parent();

        System.out.println(parent.wealth);
        System.out.println(parent.familyToilet);
        System.out.println(parent.phoneNumber);
    }
}
