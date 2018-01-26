package com.geo.ignite.config;

import co.id.artslv.lib.inventory.Inventory;
import com.geo.ignite.jpaRepository.InventoryRepository;
import org.apache.ignite.IgniteException;
import org.apache.ignite.cache.store.CacheStoreAdapter;
import org.apache.ignite.lang.IgniteBiInClosure;
import org.apache.ignite.lifecycle.LifecycleAware;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.cache.Cache;
import javax.cache.integration.CacheLoaderException;
import javax.cache.integration.CacheWriterException;
import java.util.List;

public class InventoryStore extends CacheStoreAdapter<String, Inventory> implements LifecycleAware{
    private static final Logger logger = LoggerFactory.getLogger(InventoryStore.class);

    private static InventoryRepository inventoryRepository;

    @Override
    public Inventory load(String s) throws CacheLoaderException {
        return inventoryRepository.findOne(s);
    }

    @Override
    public void write(Cache.Entry<? extends String, ? extends Inventory> entry) throws CacheWriterException {
        Inventory inventory = entry.getValue();
        inventoryRepository.save(inventory);
    }

    @Override
    public void delete(Object o) throws CacheWriterException {
        String inventoryId = (String)o;
        inventoryRepository.delete(inventoryId);
    }

    @Override
    public void loadCache(IgniteBiInClosure<String, Inventory> clo, Object... args) {
        logger.info("Start Load Cache Data");
        super.loadCache(clo, args);
        List<Inventory> inventories = inventoryRepository.findAll();
        inventories.forEach(inventory -> {
            clo.apply(inventory.getId(),inventory);
        });
        logger.info("Finish Load Cache Data");
    }

    @Override
    public void start() throws IgniteException {

    }

    @Override
    public void stop() throws IgniteException {

    }

    public static void setInventoryRepository(InventoryRepository inventoryRepository) {
        InventoryStore.inventoryRepository = inventoryRepository;
    }
}
