package com.pcdgroup.cms.PcdEcom.Vendorinventory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorinventoryRepository extends CrudRepository<Vendorinventorymaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT vendorinventoryid FROM vendorinventorymaster ORDER BY vendorinventoryid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT vendorinventoryid, vid, invid FROM vendorinventorymaster WHERE vendorinventoryid = ?1")
	Vendorinventorymaster getVendorinventory(Integer vendorinventoryid);
	
	@Query(nativeQuery = true, value = "SELECT vendorinventoryid, vid, invid FROM vendorinventorymaster")
	List<Vendorinventorymaster> getAllVendorinventory();
	
}
