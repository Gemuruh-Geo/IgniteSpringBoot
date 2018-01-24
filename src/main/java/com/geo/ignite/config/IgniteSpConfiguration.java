package com.geo.ignite.config;

import co.id.artslv.lib.inventory.Inventory;
import com.geo.ignite.model.Person;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteSpConfiguration {
    public static final String INVENTORY_CACHE = "inventoryCache";//Inventory Cache


    @Bean(name = "igniteInstance") //To be recognized by IgniteRepositoryFactoryBean, the bean name must be igniteInstance
    public Ignite ignite(){
        IgniteConfiguration cfg = new IgniteConfiguration();

        // Setting some custom name for the node.
        cfg.setIgniteInstanceName("springDataNode");

        // Enabling peer-class loading feature.
        cfg.setPeerClassLoadingEnabled(true);

        // Defining and creating a new cache to be used by Ignite Spring Data repository.
        CacheConfiguration ccfg = new CacheConfiguration("PersonCache");


        //Inventory Cache
        CacheConfiguration<String,Inventory> inventoryCcfg = new CacheConfiguration(INVENTORY_CACHE);

        // Setting SQL schema for the cache.
        ccfg.setIndexedTypes(Long.class, Person.class);

        inventoryCcfg.setIndexedTypes(String.class,Inventory.class); //inventory configuration

        cfg.setCacheConfiguration(ccfg,inventoryCcfg); //add inventory cache


        return Ignition.start(cfg);
    }



}
