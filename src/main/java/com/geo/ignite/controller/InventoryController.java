package com.geo.ignite.controller;

import co.id.artslv.lib.inventory.Inventory;
import com.geo.ignite.service.InventoryServiceTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
    @Autowired
    private InventoryServiceTest inventoryServiceTest;

    @RequestMapping(value = "/testInv",method = RequestMethod.GET)
    public Inventory test(){
        inventoryServiceTest.init();
        return null;
    }
}
