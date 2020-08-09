package com.sda.hibernate.states;

import com.sda.hibernate.config.HibernateUtil;
import com.sda.hibernate.crud.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DemoHibernateStates {

    public static void main(String[] args) {
        // transient
        Person person = new Person();
        person.setFirstName("jon");

        // get session
        Session session = HibernateUtil.getSessionFactory().openSession();

        // begin transaction
        Transaction tx = session.beginTransaction();

        // save - persistent
        session.save(person);
        // persistent object state

        session.close();
        // detached
    }
}
