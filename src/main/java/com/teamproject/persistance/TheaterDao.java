package com.teamproject.persistance;

import com.teamproject.entity.SessionFactoryProvider;
import com.teamproject.entity.Theater;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.util.List;

public class TheaterDao implements Dao<Theater> {

    SessionFactory sessionFactory = SessionFactoryProvider.getSessionFactory();
    @Override
    public List<Theater> getAll() {
        return null;
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
        return 0;
    }

    @Override
    public boolean update(Theater entity) {
        return false;
    }

    @Override
    public boolean delete(Theater entity) {
        return false;
    }
}
