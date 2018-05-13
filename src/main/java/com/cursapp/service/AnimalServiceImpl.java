package com.cursapp.service;

import com.cursapp.DAO.AnimalDAO;
import com.cursapp.Entity.AnimalsEntity;
import com.cursapp.service.interfaces.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("animalService")
@Transactional
public class AnimalServiceImpl implements AnimalService {
    @Autowired
    private AnimalDAO animalDAO;
    @Transactional
    public void setAnimalDAO(AnimalDAO animalDAO) {
        this.animalDAO = animalDAO;
    }
    @Transactional
    public void add(AnimalsEntity p) {
        animalDAO.add(p);
    }
    @Transactional
    public void update(AnimalsEntity p) {
        animalDAO.update(p);
    }
    @Transactional
    public void remove(int id) {
        animalDAO.remove(id);
    }
    @Transactional
    public List<AnimalsEntity> List() {
        return animalDAO.List();
    }
    @Transactional
    public AnimalsEntity getById(int id) {
        return animalDAO.getById(id);
    }
    @Transactional
    public void save(AnimalsEntity p) {
        animalDAO.save(p);
    }
}
