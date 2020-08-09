package com.sda.hibernate.queries.hql;

import com.sda.hibernate.config.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

public class StockDao {

    private Session session;
    private Transaction tx;

    public void create(Stock stock) {
        try {
            startOperation();
            session.save(stock);
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
    public List findAllWithHqlQuery() {
        List result = new ArrayList();
        try {
            startOperation();

            String hql = "from Stock";
            // query using HQL
            Query query = session.createQuery(hql, Stock.class);
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

    public List findAllByStockCodeWithNamedQuery(String stockCode) {
        List result = new ArrayList();
        try {
            startOperation();

            // named query with parameters using HQL
            Query query = session.createNamedQuery("findStockByStockCode");
            // use query from javax.persistence
            query.setParameter("stockCode", stockCode);
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
