package com.bucur.recap.access_modifiers.away;

import com.bucur.recap.access_modifiers.home.Parent;

public class Neighbor {

    public void hasAccessTo() {
        Parent parent = new Parent();
        System.out.println(parent.phoneNumber);
    }
}
