package com.pcdgroup.cms.PcdEcom.Vendor;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendorRepository extends CrudRepository<Vendormaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT vendorid FROM vendormaster ORDER BY vendorid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT vendorid, vendorfname, vendorlname, vendorproductbrand, vendoremail, vendorcontactno, vendoraddress, vendorpassword FROM vendormaster WHERE vendorid = ?1")
	Vendormaster getVendorDetails(Integer vendorid);
	
	@Query(nativeQuery = true, value = "SELECT vendorid, vendorfname, vendorlname, vendorproductbrand, vendoremail, vendorcontactno, vendoraddress, vendorpassword FROM vendormaster")
	List<Vendormaster> getAllVendorsDetails();
	
	@Query(nativeQuery = true, value = "SELECT vendorid, vendorfname, vendorlname, vendorproductbrand, vendoremail, vendorcontactno, vendoraddress, vendorpassword FROM vendormaster WHERE vendoremail = ?1")
	Vendormaster checkDuplicateEmail(String email);
	
	@Query(nativeQuery = true, value = "SELECT vendorid, vendorfname, vendorlname, vendorproductbrand, vendoremail, vendorcontactno, vendoraddress, vendorpassword FROM vendormaster WHERE vendoremail = ?1 and vendorid <> ?2")
	Vendormaster checkDuplicateEmail(String email, Integer vendorid);
	
	@Query(nativeQuery = true, value = "SELECT vendorid, vendorfname, vendorlname, vendorproductbrand, vendoremail, vendorcontactno, vendoraddress, vendorpassword FROM vendormaster WHERE vendorid = ?1")
	Vendormaster checkDeleteIdExist(Integer vendorid);
	
}
