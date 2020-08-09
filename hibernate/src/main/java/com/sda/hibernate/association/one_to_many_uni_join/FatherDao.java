package com.sda.hibernate.association.one_to_many_uni_join;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class FatherDao {

    private Session session;
    private Transaction tx;

    public void create(Father father) {
        try {
            startOperation();
            session.save(father);
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

    public Father findById(Long id) {
        Father father = null;
        try {
            startOperation();
            father = session.find(Father.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return father;
    }

    public void update(Father father) {
        try {
            startOperation();
            session.update(father);
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

    public void delete(Father father) {
        try {
            startOperation();
            session.delete(father);
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
