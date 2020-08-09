package com.sda.hibernate.association.one_to_many_uni;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoOneToManyUnidirectional {

    public static void main(String[] args) {
        // create mother
        Mother mother = new Mother();
        mother.setName("mother");
        mother.setEmail("mother@gmail.com");

        Daughter daughter1 = new Daughter();
        daughter1.setTitle("daughter1");

        Daughter daughter2 = new Daughter();
        daughter2.setTitle("daughter2");

        // create 2 daughters

        // option 1
        List<Daughter> daughters = new ArrayList<>();
        daughters.add(daughter1);
        daughters.add(daughter2);

        mother.setDaughters(daughters);

        // option 2
//            mother.getDaughters().add(daughter1);

        // save
        MotherDao dao = new MotherDao();
        dao.create(mother);
    }
}
