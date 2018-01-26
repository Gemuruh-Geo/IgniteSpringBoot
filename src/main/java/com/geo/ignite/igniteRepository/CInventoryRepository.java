package com.geo.ignite.igniteRepository;

import com.geo.ignite.config.IgniteSpConfiguration;
import com.geo.ignite.model.CInventory;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import java.util.List;

@RepositoryConfig(cacheName = IgniteSpConfiguration.INVENTORY_CACHE)
public interface CInventoryRepository extends IgniteRepository<CInventory,String>{
    List<CInventory> findBySchedulenoka(String noka);
}
