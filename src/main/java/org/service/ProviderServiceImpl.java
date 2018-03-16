package org.service;

import org.DAO.ProviderDAO;
import org.Entity.ProvidersEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    private ProviderDAO providerDAO;

    public void setProviderDAO(ProviderDAO providerDAO) {
        this.providerDAO = providerDAO;
    }

    public void addProvider(ProvidersEntity p) {
        providerDAO.add(p);
    }

    public void updateProvider(ProvidersEntity p) {
        providerDAO.update(p);
    }

    public void removeProvider(int id) {
        providerDAO.remove(id);
    }

    public List<ProvidersEntity> ProviderList() {
        return providerDAO.List();
    }

    public ProvidersEntity getProviderById(int id) {
        return providerDAO.getById(id);
    }

    public void saveProvider(ProvidersEntity p) {
        providerDAO.save(p);

    }
}
