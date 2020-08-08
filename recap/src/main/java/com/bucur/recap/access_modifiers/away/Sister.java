package com.bucur.recap.access_modifiers.away;

import com.bucur.recap.access_modifiers.home.*;

public class Sister extends Parent {

    public void hasAccessTo() {
        System.out.println(super.wealth);
        System.out.println(super.phoneNumber);
    }
}
