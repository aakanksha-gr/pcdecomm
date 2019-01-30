package com.pcdgroup.cms.PcdEcom.Bill;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BillRepository extends CrudRepository<Billmaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT billid FROM billmaster ORDER BY billid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT billno FROM billmaster ORDER BY billno DESC LIMIT 0, 1")
	Integer getMaxOrderno();
	
	//billid billno billorderid
	
}
