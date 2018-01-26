package com.geo.ignite.controller;

import co.id.artslv.lib.inventory.Inventory;
import com.geo.ignite.config.IgniteSpConfiguration;
import com.geo.ignite.igniteRepository.CInventoryRepository;
import com.geo.ignite.jpaRepository.InventoryRepository;
import org.apache.ignite.Ignite;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
public class InventoryController {

    @Autowired private Ignite igniteInstance;
    @Autowired private InventoryRepository inventoryRepository;
    @Autowired private CInventoryRepository cInventoryRepository;
    private static final Logger logger = LoggerFactory.getLogger(InventoryController.class);


    @RequestMapping(value = "/init",method = RequestMethod.GET)
    public void init(){
        igniteInstance.getOrCreateCache(IgniteSpConfiguration.INVENTORY_CACHE).loadCache(null);
    }

    @RequestMapping(value = "/getFromNoKA",method = RequestMethod.GET)
    public List<Inventory> getFromNoKA(){
        List<Inventory> res = new ArrayList<>();
        Iterator<Inventory> r = cInventoryRepository.findBySchedulenoka("581583").iterator();
        while (r.hasNext()){
            res.add(r.next());
        }
        return res;
    }

    @RequestMapping(value = "/getAllFromCache",method = RequestMethod.GET)
    public List<Inventory> getFromCacheTest(){

        long start = System.currentTimeMillis();
        List<Inventory> result = new ArrayList<>();
        Iterator<Inventory> inventoryIterator = cInventoryRepository.findAll().iterator();
        while (inventoryIterator.hasNext()){
            result.add(inventoryIterator.next());
        }

        long end = System.currentTimeMillis();
        logger.info("GET FROM CACHE {}",(end-start));

        return result;
    }
}
