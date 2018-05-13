package com.cursapp.service;

import com.cursapp.DAO.ProductDAO;
import com.cursapp.Entity.ProductsEntity;
import com.cursapp.service.interfaces.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;
    @Transactional
    public void setProductDAO(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }
    @Transactional
    public void add(ProductsEntity p) {
        productDAO.add(p);
    }
    @Transactional
    public void update(ProductsEntity p) {
        productDAO.update(p);
    }
    @Transactional
    public void remove(int id) {
        productDAO.remove(id);
    }
    @Transactional
    public List<ProductsEntity> List() {
        return productDAO.List();
    }
    @Transactional
    public ProductsEntity getById(int id) {
        return productDAO.getById(id);
    }
    @Transactional
    public void save(ProductsEntity p) {
        productDAO.save(p);
    }
}
