package org.service;

import org.Entity.ProvidersEntity;

import java.util.List;

public interface ProviderService {
    void addProvider(ProvidersEntity p);

    void updateProvider(ProvidersEntity p);

    void removeProvider(int id);

    List<ProvidersEntity> ProviderList();

    ProvidersEntity getProviderById(int p);

    void saveProvider(ProvidersEntity p);
}
