package com.sda.hibernate.transactions;

import com.sda.hibernate.config.HibernateUtil;
import com.sda.hibernate.crud.Person;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DemoTransactionManagement {

    public static void main(String[] args) {
        Session session = null;
        Transaction tx = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            tx.setTimeout(5);

            Person person = new Person();
            person.setFirstName("jon");
            session.save(person);

            tx.commit();
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
