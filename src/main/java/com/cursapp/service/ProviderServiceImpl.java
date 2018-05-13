package com.cursapp.service;

import com.cursapp.DAO.ProviderDAO;
import com.cursapp.Entity.ProvidersEntity;
import com.cursapp.service.interfaces.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("providerService")
@Transactional
public class ProviderServiceImpl implements ProviderService {
    @Autowired
    private ProviderDAO providerDAO;
    @Transactional
    public void setProviderDAO(ProviderDAO providerDAO) {
        this.providerDAO = providerDAO;
    }
    @Transactional
    public void addProvider(ProvidersEntity p) {
        providerDAO.add(p);
    }
    @Transactional
    public void updateProvider(ProvidersEntity p) {
        providerDAO.update(p);
    }
    @Transactional
    public void removeProvider(int id) {
        providerDAO.remove(id);
    }
    @Transactional
    public List<ProvidersEntity> ProviderList() {
        return providerDAO.List();
    }
    @Transactional
    public ProvidersEntity getProviderById(int id) {
        return providerDAO.getById(id);
    }
    @Transactional
    public void saveProvider(ProvidersEntity p) {
        providerDAO.save(p);

    }
}
