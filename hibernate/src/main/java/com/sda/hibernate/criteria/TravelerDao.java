package com.sda.hibernate.criteria;

import com.sda.hibernate.config.HibernateUtil;
import com.sda.hibernate.queries.native_query.Trader;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TravelerDao {

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

    public List<Traveler> findAll() {
        List<Traveler> result = new ArrayList<>();
        try {
            startOperation();

            CriteriaQuery<Traveler> query = session.getCriteriaBuilder()
                .createQuery(Traveler.class);

            result = session.createQuery(
                // select * from traveler
                query.select(query.from(Traveler.class))).list();

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

    public List<Traveler> findByGenderAndCountryCode(Gender gender, String countryCode) {
        List<Traveler> result = new ArrayList<>();
        try {
            startOperation();

            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<Traveler> query = cb.createQuery(Traveler.class);
            Root<Traveler> root = query.from(Traveler.class);

            result = session.createQuery(
                // select * from traveler
                query.select(root)
                    // add filtering conditions
                    .where(
                        cb.equal(root.join("country").get("code"), countryCode),
                        cb.equal(root.get("gender"), gender)
                    )
            ).list();

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
