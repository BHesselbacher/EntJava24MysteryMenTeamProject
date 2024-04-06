package com.teamproject.persistance;

import com.teamproject.entity.SessionFactoryProvider;
import com.teamproject.entity.Theater;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.criteria.HibernateCriteriaBuilder;

import java.util.List;

public class TheaterDao implements Dao<Theater> {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    @Override
    public List<Theater> getAll() {
        Session session = sessionFactory.openSession();
        HibernateCriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Theater> query = builder.createQuery(Theater.class);
        Root<Theater> root = query.from(Theater.class);
        List<Theater> theaters = session.createSelectionQuery(query).getResultList();

        session.close();
        return theaters;
    }

    @Override
    public Theater getById(int id) {
        Session session = sessionFactory.openSession();
        Theater theater = session.get( Theater.class, id );
        session.close();
        return theater;
    }

    @Override
    public int insert(Theater entity) {
        int id = 0;
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(entity);
        transaction.commit();
        id = entity.getTheaterId();
        session.close();

        return id;
    }

    @Override
    public boolean update(Theater entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.merge(entity);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Theater entity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.delete(entity);
        transaction.commit();

        session.close();
        return true;
    }
}
