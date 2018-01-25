package com.geo.ignite.config;

import co.id.artslv.lib.inventory.Inventory;
import com.geo.ignite.jpaRepository.InventoryRepository;
import org.apache.ignite.IgniteException;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.lifecycle.LifecycleAware;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;

public class InventoryStore extends CacheStoreAdapter<String, Inventory> implements LifecycleAware{

    private InventoryRepository inventoryRepository;

    @Override
    public Inventory load(String s) throws CacheLoaderException {
        return null;
    }

    @Override
    public void write(Cache.Entry<? extends String, ? extends Inventory> entry) throws CacheWriterException {

    }

    @Override
    public void delete(Object o) throws CacheWriterException {

    }

    @Override
    public void start() throws IgniteException {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(RepositoryConfig.class);
        configApplicationContext.refresh();

        inventoryRepository = configApplicationContext.getBean(InventoryRepository.class);
    }

    @Override
    public void stop() throws IgniteException {

    }
}
