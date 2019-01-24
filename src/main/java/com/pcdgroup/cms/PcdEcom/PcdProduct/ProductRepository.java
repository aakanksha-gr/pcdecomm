package com.pcdgroup.cms.PcdEcom.PcdProduct;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Productmaster, Integer> {
	
	@Query(nativeQuery = true, value="SELECT productid, productname, productimage, producttype, productprice, productminimumstock, productstock, hsncode, gst, pcdproductstockstatus from  pcdproductmaster LIMIT ?1, 6")
	List<Productmaster> getAllPcdProducts(Integer startIndex);
	
	@Query(nativeQuery = true, value = "SELECT productid, productname, productimage, producttype, productprice, productminimumstock, productstock, hsncode, gst, pcdproductstockstatus from  pcdproductmaster Where productid = ?1")
	List<Productmaster> getPcdProductById(Integer productid);
	
	@Query(nativeQuery = true, value = "SELECT productid FROM pcdproductmaster ORDER BY productid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT productid FROM pcdproductmaster WHERE productid = ?1")
	Integer getProductid(Integer pid);
	
	@Query(nativeQuery = true, value = "SELECT productid, productname, productimage, producttype, productprice, productminimumstock, productstock, hsncode, gst, pcdproductstockstatus from  pcdproductmaster Where LOWER(TRIM(productname)) = LOWER(?1) LIMIT 0, 1")
	Productmaster getDuplicateName(String pname);
	
	@Query(nativeQuery = true, value = "SELECT productid, productname, productimage, producttype, productprice, productminimumstock, productstock, hsncode, gst, pcdproductstockstatus from  pcdproductmaster Where LOWER(TRIM(productname)) = LOWER(?1) AND productid <> ?2  LIMIT 0, 1")
	Productmaster getDuplicateName(String pname, Integer id);
	
	@Query(nativeQuery = true, value = "SELECT productid, productname, productimage, producttype, productprice, productminimumstock, productstock, hsncode, gst, pcdproductstockstatus from  pcdproductmaster "
			+ "WHERE LOWER(trim(pcdproductstockstatus)) = LOWER(trim('out of stock')) LIMIT ?1, 6")
	List<Productmaster> getAllOutofstockProducts(Integer startindx);
	
}
