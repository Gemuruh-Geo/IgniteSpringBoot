package com.geo.ignite.jpaRepository;

import co.id.artslv.lib.inventory.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory,String>{
}
