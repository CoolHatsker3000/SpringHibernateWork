package com.cursapp.DAO;

import com.cursapp.Entity.AnimalsEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository("AnimalDAO")
public class AnimalDAOImpl implements AnimalDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        sessionFactory=sf;
    }
    public void add(AnimalsEntity p) {
        Session session=sessionFactory.getCurrentSession();
        session.merge(p);
    }

    public void update(AnimalsEntity p) {
        Session session=sessionFactory.getCurrentSession();
        session.update(p);
    }

    public void remove(int id) {
        Session session=sessionFactory.getCurrentSession();
        AnimalsEntity p=(AnimalsEntity) session.get(AnimalsEntity.class, id);
        if(p!=null) {
            session.delete(p);
        }
    }

    public List<AnimalsEntity> List() {
        Session session = sessionFactory.getCurrentSession();
        List<AnimalsEntity> animalsList = session.createQuery("SELECT p FROM AnimalsEntity p").list();
        return animalsList;
    }

    public AnimalsEntity getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        AnimalsEntity p = (AnimalsEntity) session.load(AnimalsEntity.class, id);
        return p;
    }

    public void save(AnimalsEntity p) {
        Session session=sessionFactory.getCurrentSession();
        session.save(p);
    }
}
