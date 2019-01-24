package com.pcdgroup.cms.PcdEcom.Dealor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DealorRepository extends CrudRepository<Dealormaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT dealorid FROM dealormaster ORDER BY dealorid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT dealorid, dealorfname, dealorlname, dealornumber, dealoremail, dealorpassword, dealorproductbrand, dealoraddress FROM dealormaster ORDER BY dealorid LIMIT ?1, 10")
	List<Dealormaster> getAllDealors(Integer index);
	
	@Query(nativeQuery = true, value = "SELECT dealorid, dealorfname, dealorlname, dealornumber, dealoremail, dealorpassword, dealorproductbrand, dealoraddress FROM dealormaster WHERE dealorid = ?1")
	Dealormaster getDealorById(Integer id);
	
	@Query(nativeQuery = true, value = "SELECT dealorid, dealorfname, dealorlname, dealornumber, dealoremail, dealorpassword, dealorproductbrand, dealoraddress FROM dealormaster WHERE LOWER(trim(dealoremail)) = LOWER(trim(?1)) and dealorid <> ?2")
	Dealormaster checkDuplicateEmail(String dealoremail, Integer dealorid);
	
	@Query(nativeQuery = true, value = "SELECT dealorid, dealorfname, dealorlname, dealornumber, dealoremail, dealorpassword, dealorproductbrand, dealoraddress FROM dealormaster WHERE LOWER(trim(dealoremail)) = LOWER(trim(?1))")
	Dealormaster checkDuplicateEmail(String dealoremail);
	
	@Query(nativeQuery = true, value = "SELECT dealorid, dealorfname, dealorlname, dealornumber, dealoremail, dealorpassword, dealorproductbrand, dealoraddress FROM dealormaster "
			+ "WHERE LOWER(trim(dealoremail)) = LOWER(trim(?1)) and LOWER(trim(dealorpassword)) = LOWER(trim(?2)) LIMIT 0, 1")
	Dealormaster checkDealorLogin(String dealoremail, String dealorpassword);
	
}
