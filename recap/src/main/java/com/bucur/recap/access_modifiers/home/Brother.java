package com.bucur.recap.access_modifiers.home;

public class Brother extends Parent {

    public void hasAccessTo() {
        System.out.println(super.wealth);
        System.out.println(super.familyToilet);
        System.out.println(super.phoneNumber);
    }
}
