package com.teamproject.persistance;

import com.teamproject.entity.Theater;

import java.util.List;

public class TheaterDao implements Dao<Theater> {
    @Override
    public List<Theater> getAll() {
        return null;
    }

    @Override
    public Theater getById(int id) {
        return null;
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
