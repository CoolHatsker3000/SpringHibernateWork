package com.cursapp.service.interfaces;

import com.cursapp.Entity.ProductsEntity;

import java.util.List;

public interface ProductService {
    void add(ProductsEntity p);

    void update(ProductsEntity p);

    void remove(int id);

    List<ProductsEntity> List();

    ProductsEntity getById(int p);

    void save(ProductsEntity p);
}
