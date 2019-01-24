package com.pcdgroup.cms.PcdEcom.Inventory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends CrudRepository<Inventorymaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT inventoryid FROM inventorymaster ORDER BY inventoryid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT inventoryid, inventoryname, inventorybrand, inventorylocation, inventoryquantity, inventorymimimumstock, inventorystock, inventorystockstatus, inventoryhsncode, inventorygst FROM inventorymaster WHERE inventoryid = ?1")
	Inventorymaster getInventory(Integer inventoryid);
	
	@Query(nativeQuery = true, value = "SELECT inventoryid, inventoryname, inventorybrand, inventorylocation, inventoryquantity, inventorymimimumstock, inventorystock, inventorystockstatus, inventoryhsncode, inventorygst FROM inventorymaster")
	List<Inventorymaster> getAllInventory();
	
	@Query(nativeQuery = true, value = "SELECT inventoryid, inventoryname, inventorybrand, inventorylocation, inventoryquantity, inventorymimimumstock, inventorystock, inventorystockstatus, inventoryhsncode, inventorygst FROM inventorymaster "
			+ "WHERE LOWER(trim(inventorystockstatus)) = LOWER(trim('out of stock'))")
	List<Inventorymaster> getAllOutofstockInventory();
	
	@Query(nativeQuery = true, value = "SELECT inventoryid, inventoryname, inventorybrand, inventorylocation, inventoryquantity, inventorymimimumstock, inventorystock, inventorystockstatus, inventoryhsncode, inventorygst FROM inventorymaster "
			+ "WHERE LOWER(trim(inventorybrand)) = LOWER(trim(?1)) LIMIT 10")
	List<Inventorymaster> getAllInventoryByBrand(String brand);
	
}
