package com.cursapp.DAO;

import com.cursapp.Entity.ProvidersEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("providerDAO")
public class ProviderDAOImpl implements ProviderDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        sessionFactory=sf;
    }

    public void add(ProvidersEntity p) {
        Session session=sessionFactory.getCurrentSession();
        session.merge(p);
    }

    public void update(ProvidersEntity p) {
        Session session=sessionFactory.getCurrentSession();
        session.update(p);
    }

    public void remove(int id) {
        Session session=sessionFactory.getCurrentSession();
        ProvidersEntity p=(ProvidersEntity)session.get(ProvidersEntity.class, id);
        if (p!=null){
            session.delete(p);
        }
    }

    public List<ProvidersEntity> List() {
        Session session = sessionFactory.getCurrentSession();
        List<ProvidersEntity> providersList = session.createQuery("SELECT p FROM ProvidersEntity p").list();
        return providersList;
    }

    public ProvidersEntity getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        System.out.println("THIS ID: "+id);
        ProvidersEntity p = (ProvidersEntity) session.load(ProvidersEntity.class, id);
        System.out.println(p.getName());
        System.out.println(p.getOfficeAdress());
        return p;
    }

    public void save(ProvidersEntity p) {
        Session session=sessionFactory.getCurrentSession();
        session.save(p);
    }
}
