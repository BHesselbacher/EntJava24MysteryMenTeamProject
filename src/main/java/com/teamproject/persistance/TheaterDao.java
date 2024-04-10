package com.teamproject.persistance;

import com.teamproject.entity.Theater;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class TheaterDao implements Dao<Theater> {

    private final SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();

    @Override
    public List<Theater> getAll() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM Theater", Theater.class).list();
        }
    }

    @Override
    public Theater getById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(Theater.class, id);
        }
    }

    @Override
    public int insert(Theater entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(entity);
            transaction.commit();
            return entity.getTheaterId();
        }
    }

    @Override
    public boolean update(Theater entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(entity);
            transaction.commit();
            return true;
        }
    }

    @Override
    public boolean delete(Theater entity) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.delete(entity);
            transaction.commit();
            return true;
        }
    }
}
