package com.geo.ignite.service;

import co.id.artslv.lib.inventory.Inventory;
import com.geo.ignite.config.IgniteSpConfiguration;
import com.geo.ignite.jpaRepository.InventoryRepository;
import org.apache.ignite.Ignite;
import org.apache.ignite.IgniteCache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceTest {
    @Autowired
    @Qualifier("igniteInstance")
    private Ignite ignite;


    public void init(){
        IgniteCache<String,Inventory> igniteCache = ignite.getOrCreateCache(IgniteSpConfiguration.INVENTORY_CACHE);
        igniteCache.loadCache(null);
    }


}
