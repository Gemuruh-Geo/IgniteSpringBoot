package com.geo.ignite.config;

import com.geo.ignite.jpaRepository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RepositoryConfig {
    @Autowired
    private InventoryRepository inventoryRepository;

    @Bean(name = "inventoryRepository")
    public InventoryRepository getInventoryRepository() {
        return inventoryRepository;
    }
}
