package org.DAO;

import org.Entity.AnimalsEntity;

import java.util.List;

public interface AnimalDAO {
    public void add(AnimalsEntity p);

    public void update(AnimalsEntity p);

    public void remove(int id);

    public List<AnimalsEntity> List();

    public AnimalsEntity getById(int id);

    public void save(AnimalsEntity p);
}
