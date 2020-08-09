package com.sda.hibernate.association.one_to_many_bi;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ParentDao {

    private Session session;
    private Transaction tx;

    public void create(Parent parent) {
        try {
            startOperation();
            session.save(parent);
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

    public Parent findById(Long id) {
        Parent parent = null;
        try {
            startOperation();
            parent = session.find(Parent.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return parent;
    }

    public void update(Parent parent) {
        try {
            startOperation();
            session.update(parent);
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

    public void delete(Parent parent) {
        try {
            startOperation();
            session.delete(parent);
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
