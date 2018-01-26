package com.geo.ignite.config;

import co.id.artslv.lib.inventory.Inventory;
import com.geo.ignite.jpaRepository.InventoryRepository;
import com.geo.ignite.model.CInventory;
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

public class InventoryStore extends CacheStoreAdapter<String, CInventory> implements LifecycleAware{
    private static final Logger logger = LoggerFactory.getLogger(InventoryStore.class);

    private static InventoryRepository inventoryRepository;

    @Override
    public CInventory load(String s) throws CacheLoaderException {

        return convert(inventoryRepository.findOne(s));
    }

    @Override
    public void write(Cache.Entry<? extends String, ? extends CInventory> entry) throws CacheWriterException {
        Inventory inventory = convert(entry.getValue());
        inventoryRepository.save(inventory);
    }

    @Override
    public void delete(Object o) throws CacheWriterException {
        String inventoryId = (String)o;
        inventoryRepository.delete(inventoryId);
    }

    @Override
    public void loadCache(IgniteBiInClosure<String, CInventory> clo, Object... args) {
        logger.info("Start Load Cache Data");
        super.loadCache(clo, args);
        List<Inventory> inventories = inventoryRepository.findAll();
        inventories.forEach(inventory -> {
            clo.apply(inventory.getId(),convert(inventory));
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


    private CInventory convert(Inventory inventory){
        CInventory cInventory = new CInventory();

        cInventory.setId(inventory.getId());


        cInventory.setSchedulenoka(inventory.getSchedulenoka());

        cInventory.setTripid(inventory.getTripid());

        cInventory.setTripdate(inventory.getTripdate());

        cInventory.setStopid(inventory.getStopid());

        cInventory.setStasiuncode(inventory.getStasiuncode());

        cInventory.setStoporder(inventory.getStoporder());

        cInventory.setStamformdetid(inventory.getStamformdetid());

        cInventory.setStamformdetcode(inventory.getStamformdetcode());

        cInventory.setStamformdetorder(inventory.getStamformdetorder());

        cInventory.setWagondetid(inventory.getWagondetid());

        cInventory.setWagondetrow(inventory.getWagondetrow());

        cInventory.setWagondetcol(inventory.getWagondetcol());

        cInventory.setSubclassid(inventory.getSubclassid());

        cInventory.setSubclasscode(inventory.getSubclasscode());

        cInventory.setBookstat(inventory.getBookstat());

        cInventory.setStatus(inventory.getStatus());

        cInventory.setDomain(inventory.getDomain());

        cInventory.setModifiedby(inventory.getModifiedby());


        cInventory.setModifiedon(inventory.getModifiedon());

        cInventory.setWagondetcolnum(inventory.getWagondetcolnum());

        cInventory.setCreatedby(inventory.getCreatedby());


        cInventory.setCreatedon(inventory.getCreatedon());

        cInventory.setBookcode(inventory.getBookcode());

        cInventory.setTransactiondetorder(inventory.getTransactiondetorder());

        cInventory.setTransactiondetticketnum(inventory.getTransactiondetticketnum());

        cInventory.setSeatopen(inventory.getSeatopen());

        cInventory.setBlockstat(inventory.getBlockstat());

        cInventory.setErrorDescription(inventory.getErrorDescription());

        return cInventory;

    }

    private Inventory convert(CInventory cInventory){
        Inventory inventory = new Inventory();

        inventory.setId(cInventory.getId());


        inventory.setSchedulenoka(cInventory.getSchedulenoka());

        inventory.setTripid(cInventory.getTripid());

        inventory.setTripdate(cInventory.getTripdate());

        inventory.setStopid(cInventory.getStopid());

        inventory.setStasiuncode(cInventory.getStasiuncode());

        inventory.setStoporder(cInventory.getStoporder());

        inventory.setStamformdetid(cInventory.getStamformdetid());

        inventory.setStamformdetcode(cInventory.getStamformdetcode());

        inventory.setStamformdetorder(cInventory.getStamformdetorder());

        inventory.setWagondetid(cInventory.getWagondetid());

        inventory.setWagondetrow(cInventory.getWagondetrow());

        inventory.setWagondetcol(cInventory.getWagondetcol());

        inventory.setSubclassid(cInventory.getSubclassid());

        inventory.setSubclasscode(cInventory.getSubclasscode());

        inventory.setBookstat(cInventory.getBookstat());

        inventory.setStatus(cInventory.getStatus());

        inventory.setDomain(cInventory.getDomain());

        inventory.setModifiedby(cInventory.getModifiedby());


        inventory.setModifiedon(cInventory.getModifiedon());

        inventory.setWagondetcolnum(cInventory.getWagondetcolnum());

        inventory.setCreatedby(cInventory.getCreatedby());


        inventory.setCreatedon(cInventory.getCreatedon());

        inventory.setBookcode(cInventory.getBookcode());

        inventory.setTransactiondetorder(cInventory.getTransactiondetorder());

        inventory.setTransactiondetticketnum(cInventory.getTransactiondetticketnum());

        inventory.setSeatopen(cInventory.getSeatopen());

        inventory.setBlockstat(cInventory.getBlockstat());

        inventory.setErrorDescription(cInventory.getErrorDescription());
        return inventory;

    }
}
