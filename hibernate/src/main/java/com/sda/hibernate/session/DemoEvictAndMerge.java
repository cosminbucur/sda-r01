package com.sda.hibernate.session;

import com.sda.hibernate.config.HibernateUtil;
import com.sda.hibernate.crud.Person;
import org.hibernate.Session;

public class DemoEvictAndMerge {

    public static void main(String[] args) {
        Person person = new Person();
        person.setFirstName("jon");

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        session.save(person);

        Person foundPerson = session.find(Person.class, 1L);
        System.out.println(foundPerson.getFirstName());

        // evict
        session.evict(foundPerson);
        foundPerson.setFirstName("evicted");

        // sync memory with db
        session.flush();

        foundPerson = session.find(Person.class, 1L);
        System.out.println("after evict - first name = " + foundPerson.getFirstName());

        // merge object
        session.merge(foundPerson);
        foundPerson.setFirstName("merged");

        session.flush();

        foundPerson = session.find(Person.class, 1L);
        System.out.println("after merge - first name = " + foundPerson.getFirstName());

        session.close();
    }
}
