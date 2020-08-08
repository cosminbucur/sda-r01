package com.sda.hibernate.crud;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

// DATA ACCESS OBJECT
public class PersonDao {

    // create
    public void create(Person person) {
        Transaction transaction = null;
        Session session = null;
        try {
            // create session
            SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
            session = sessionFactory.openSession();

            // create transaction
            transaction = session.beginTransaction();

            // save operation
            session.save(person);

            // commit transaction
            transaction.commit();
        } catch (Exception e) {
            // if error during transaction > rollback
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            // close session
            if (session != null) {
                session.close();
            }
        }

    }

    // find by id
    public Person findById(Long id) {
        // session.find
        Session session = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();

            Person person = session.find(Person.class, id);

            return person;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            // close session
            if (session != null) {
                session.close();
            }
        }
    }

    // update
    public void update(Person person) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.update(person);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    // delete
    public void delete(Person person) {
        Session session = null;
        Transaction transaction = null;

        try {
            session = HibernateUtil.getSessionFactory().openSession();
            transaction = session.beginTransaction();

            session.delete(person);

            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
}
