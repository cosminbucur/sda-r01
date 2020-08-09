package com.sda.hibernate.queries.native_query;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TraderDao {

    private Session session;
    private Transaction tx;

    public void create(Trader trader) {
        try {
            startOperation();
            session.save(trader);
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

    // find all
    public List findAllWithNativeQuery() {
        List result = new ArrayList();
        try {
            startOperation();

            String sql = "SELECT * FROM trader";
            // query using HQL
            Query query = session.createNativeQuery(sql, Trader.class);
            result = query.getResultList();

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
        return result;
    }

    public List<Trader> findAllByNameWithNamedNativeQuery(String name) {
        List<Trader> result = new ArrayList<>();
        try {
            startOperation();

            // named query with parameters using native SQL
            Query<Trader> query = session.createNamedQuery("findTraderByName", Trader.class);
            // use query from org.hibernate.query
            query.setParameter("name", name);
            result = query.getResultList();
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
        return result;
    }

    private void startOperation() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        session = sessionFactory.openSession();
        tx = session.beginTransaction();
    }
}
