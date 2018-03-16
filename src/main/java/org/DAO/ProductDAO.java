package org.DAO;

import org.Entity.ProductsEntity;

import java.util.List;

public interface ProductDAO {
    public void add(ProductsEntity p);

    public void update(ProductsEntity p);

    public void remove(int id);

    public List<ProductsEntity> List();

    public ProductsEntity getById(int id);

    public void save(ProductsEntity p);
}
