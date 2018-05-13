package com.cursapp.DAO;

import com.cursapp.Entity.ProvidersEntity;

import java.io.Serializable;
import java.util.List;

public interface ProviderDAO extends Serializable {
    public void add(ProvidersEntity p);

    public void update(ProvidersEntity p);

    public void remove(int id);

    public List<ProvidersEntity> List();

    public ProvidersEntity getById(int id);

    public void save(ProvidersEntity p);

}
