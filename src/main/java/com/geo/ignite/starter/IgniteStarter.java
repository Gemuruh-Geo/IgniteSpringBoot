package com.geo.ignite.starter;

import com.geo.ignite.config.IgniteSpConfiguration;
import com.geo.ignite.config.InventoryStore;
import com.geo.ignite.model.CInventory;
import com.geo.ignite.model.Person;
import org.apache.ignite.Ignition;
import org.apache.ignite.cache.CacheAtomicityMode;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;

import javax.cache.configuration.FactoryBuilder;

public class IgniteStarter {

    public static void main(String[] arts){
        IgniteConfiguration cfg = new IgniteConfiguration();

        // Setting some custom name for the node.
        cfg.setIgniteInstanceName("springDataNode");

        // Enabling peer-class loading feature.
        cfg.setPeerClassLoadingEnabled(true);

        // Defining and creating a new cache to be used by Ignite Spring Data repository.
        CacheConfiguration ccfg = new CacheConfiguration("PersonCache");

        // Setting SQL schema for the cache.
        ccfg.setIndexedTypes(Long.class, Person.class);

        CacheConfiguration<String,CInventory> inventoryCacheConfiguration = new CacheConfiguration<>(IgniteSpConfiguration.INVENTORY_CACHE);
        inventoryCacheConfiguration.setAtomicityMode(CacheAtomicityMode.TRANSACTIONAL);
        inventoryCacheConfiguration.setCacheStoreFactory(FactoryBuilder.factoryOf(InventoryStore.class));
        inventoryCacheConfiguration.setWriteThrough(true);
        inventoryCacheConfiguration.setReadThrough(true);
        inventoryCacheConfiguration.setWriteBehindEnabled(true);

        inventoryCacheConfiguration.setIndexedTypes(String.class,CInventory.class);

        //InventoryStore.setInventoryRepository(inventoryRepository);

        cfg.setCacheConfiguration(ccfg,inventoryCacheConfiguration);

        Ignition.start(cfg);
    }
}
