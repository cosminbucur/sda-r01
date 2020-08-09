package com.sda.hibernate.association.one_to_many_uni_join;

public class DemoOneToManyUnidirectionalJoin {

    public static void main(String[] args) {
        // father
        Father father = new Father();
        father.setName("father");
        father.setEmail("fatherland@gmail.com");

        // 2 sons
        Son son1 = new Son();
        son1.setTitle("son1");

        Son son2 = new Son();
        son2.setTitle("son2");

        father.getSons().add(son1);
        father.getSons().add(son2);

        // father save
        FatherDao dao = new FatherDao();
        dao.create(father);
    }
}
