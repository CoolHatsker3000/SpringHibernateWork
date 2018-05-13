package com.cursapp.DAO;

import com.cursapp.Entity.ProductsEntity;
import com.cursapp.model.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;
    public void setSessionFactory(SessionFactory sf){
        sessionFactory=sf;
    }
    public void add(ProductsEntity p) {
        Session session=sessionFactory.getCurrentSession();
        session.merge(p);
    }

    public void update(ProductsEntity p) {
        Session session=sessionFactory.getCurrentSession();
        session.update(p);
    }

    public void remove(int id) {
        Session session=sessionFactory.getCurrentSession();
        ProductsEntity p=(ProductsEntity) session.get(ProductsEntity.class, id);
        if(p!=null) {
            session.delete(p);
        }
    }

    public List<ProductsEntity> List() {
        Session session = sessionFactory.getCurrentSession();
        List<ProductsEntity> productsList = session.createQuery("select p FROM ProductsEntity p").list();
        return productsList;
    }

    public ProductsEntity getById(int id) {
        Session session = sessionFactory.getCurrentSession();
        ProductsEntity p = (ProductsEntity) session.load(ProductsEntity.class, id);
        return p;
    }

    public void save(ProductsEntity p) {
        Session session=sessionFactory.getCurrentSession();
        session.save(p);
    }
}
