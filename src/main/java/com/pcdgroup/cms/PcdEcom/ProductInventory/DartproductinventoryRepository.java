package com.pcdgroup.cms.PcdEcom.ProductInventory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DartproductinventoryRepository extends CrudRepository<Dartproductinventorymaster, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT dartproductinventoryid FROM dartproductinventorymaster ORDER BY dartproductinventoryid DESC LIMIT 0, 1")
	Integer getMaxId();

	@Query(nativeQuery = true, value = "SELECT dartproductinventoryid, dartproductinventorypid, dartproductinventorytid FROM dartproductinventorymaster WHERE dartproductinventoryid = ?1")
	Dartproductinventorymaster getDartproductInventory(Integer dartproductinventoryid);
	
	@Query(nativeQuery = true, value = "SELECT dartproductinventoryid, dartproductinventorypid, dartproductinventorytid FROM dartproductinventorymaster")
	List<Dartproductinventorymaster> getAllDartproductInventory();
	
}
