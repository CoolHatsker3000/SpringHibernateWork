package com.cursapp.service.interfaces;

import com.cursapp.Entity.AnimalsEntity;

import java.util.List;

public interface AnimalService {
    void add(AnimalsEntity p);

    void update(AnimalsEntity p);

    void remove(int id);

    List<AnimalsEntity> List();

    AnimalsEntity getById(int p);

    void save(AnimalsEntity p);
}
