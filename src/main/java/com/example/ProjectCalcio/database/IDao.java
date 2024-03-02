package com.example.ProjectCalcio.database;

import java.util.Map;
import com.example.ProjectCalcio.entities.Entity;

public interface IDao {
    public boolean create(Entity e);

    public Map<Integer, Entity> read();

    public boolean update(Entity e);

    public boolean delete(int id);
}
