package com.sda.hibernate.crud;

public class DemoCrud {

    public static void main(String[] args) {
        // save a person in the db
        PersonAdvancedDao dao = new PersonAdvancedDao();

        Person person = new Person();
        person.setFirstName("jon");
        person.setLastName("snow");
        person.setEmail("jonsnow@gmail.com");
        person.setCountry("westeros");

        // create
        dao.create(person);

        // read
        Person foundPerson = dao.findById(1L);

        // update
        foundPerson.setFirstName("jon1");
        foundPerson.setLastName("snow1");
        foundPerson.setEmail("jonsnow@gmail.com1");
        foundPerson.setCountry("westeros1");

        dao.update(foundPerson);
        Person updatedPerson = dao.findById(1L);
        System.out.println(updatedPerson);

        // delete
        dao.delete(updatedPerson);
    }
}
