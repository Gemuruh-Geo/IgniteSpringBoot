package com.geo.ignite.igniteRepository;

import co.id.artslv.lib.inventory.Inventory;
import com.geo.ignite.config.IgniteSpConfiguration;
import org.apache.ignite.springdata.repository.IgniteRepository;
import org.apache.ignite.springdata.repository.config.RepositoryConfig;

import java.util.List;

@RepositoryConfig(cacheName = IgniteSpConfiguration.INVENTORY_CACHE)
public interface CInventoryRepository extends IgniteRepository<Inventory,String>{
    List<Inventory> findBySchedulenoka(String noka);
}
