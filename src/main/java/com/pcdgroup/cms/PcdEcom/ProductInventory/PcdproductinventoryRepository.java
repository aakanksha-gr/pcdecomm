package com.pcdgroup.cms.PcdEcom.ProductInventory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public interface PcdproductinventoryRepository extends CrudRepository<Pcdproductinventorymaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT pcdproductinventoryid FROM pcdproductinventorymaster ORDER BY pcdproductinventoryid DESC LIMIT 0, 1")
	Integer getMaxId();

	@Query(nativeQuery = true, value = "SELECT pcdproductinventoryid, pcdproductinventorypid, pcdproductinventorytid FROM pcdproductinventorymaster WHERE pcdproductinventoryid = ?1")
	Pcdproductinventorymaster getPcdproductInventory(Integer productinventoryid);
	
	@Query(nativeQuery = true, value = "SELECT pcdproductinventoryid, pcdproductinventorypid, pcdproductinventorytid FROM pcdproductinventorymaster")
	List<Pcdproductinventorymaster> getAllPcdproductInventory();
	
}
