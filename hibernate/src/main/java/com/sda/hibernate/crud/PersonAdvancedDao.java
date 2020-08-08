package com.sda.hibernate.crud;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class PersonAdvancedDao {

    private Session session;
    private Transaction tx;

    public void create(Person person) {
        try {
            startOperation();
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

    // find by id
    public Person findById(Long id) {
        Person person = null;
        try {
            startOperation();
            person = session.find(Person.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return person;
    }

    // update
    public void update(Person person) {
        try {
            startOperation();
            session.update(person);
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

    // delete
    public void delete(Person person) {
        try {
            startOperation();
            session.delete(person);
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

    private void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
}
