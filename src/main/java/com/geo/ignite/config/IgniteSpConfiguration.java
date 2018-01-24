package com.geo.ignite.config;

import com.geo.ignite.model.Person;
import org.apache.ignite.Ignite;
import org.apache.ignite.Ignition;
import org.apache.ignite.configuration.CacheConfiguration;
import org.apache.ignite.configuration.DataStorageConfiguration;
import org.apache.ignite.configuration.IgniteConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IgniteSpConfiguration {
    @Bean(name = "igniteInstance") //To be recognized by IgniteRepositoryFactoryBean, the bean name must be igniteInstance
    public Ignite ignite(){
        IgniteConfiguration cfg = new IgniteConfiguration();

        // Setting some custom name for the node.
        cfg.setIgniteInstanceName("springDataNode");

        // Enabling peer-class loading feature.
        cfg.setPeerClassLoadingEnabled(true);

        // Defining and creating a new cache to be used by Ignite Spring Data repository.
        CacheConfiguration ccfg = new CacheConfiguration("PersonCache");

        // Setting SQL schema for the cache.
        ccfg.setIndexedTypes(Long.class, Person.class);

        cfg.setCacheConfiguration(ccfg);

        return Ignition.start(cfg);
    }



}
