package com.pcdgroup.cms.PcdEcom.DartProduct;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DartProductRepository extends CrudRepository<Dartproductmaster, Integer> {
	
	@Query(nativeQuery = true, value="SELECT dartproductid, dartproductname, dartproductimage, dartproducttype, dartproductprice, dartproductminimumstock, dartproductstock, darthsncode, dartgst, dartproductstockstatus from  dartproductmaster LIMIT ?1, 6")
	List<Dartproductmaster> getAllDartProducts(Integer startIndex);
	
	@Query(nativeQuery = true, value = "SELECT dartproductid, dartproductname, dartproductimage, dartproducttype, dartproductprice, dartproductminimumstock, dartproductstock, darthsncode, dartgst, dartproductstockstatus from  dartproductmaster Where dartproductid = ?1")
	List<Dartproductmaster> getDartProductById(Integer productid);
	
	@Query(nativeQuery = true, value = "SELECT dartproductid FROM dartproductmaster ORDER BY dartproductid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT dartproductid FROM dartproductmaster WHERE dartproductid = ?1")
	Integer getDartProductid(Integer pid);
	
	@Query(nativeQuery = true, value = "SELECT dartproductid, dartproductname, dartproductimage, dartproducttype, dartproductprice, dartproductminimumstock, dartproductstock, darthsncode, dartgst, dartproductstockstatus from  dartproductmaster Where LOWER(TRIM(dartproductname)) = LOWER(?1) LIMIT 0, 1")
	Dartproductmaster getDuplicateName(String pname);
	
	@Query(nativeQuery = true, value = "SELECT dartproductid, dartproductname, dartproductimage, dartproducttype, dartproductprice, dartproductminimumstock, dartproductstock, darthsncode, dartgst, dartproductstockstatus from  dartproductmaster Where LOWER(TRIM(dartproductname)) = LOWER(?1) AND dartproductid <> ?2  LIMIT 0, 1")
	Dartproductmaster getDuplicateName(String pname, Integer id);
	
	@Query(nativeQuery = true, value = "SELECT dartproductid, dartproductname, dartproductimage, dartproducttype, dartproductprice, dartproductminimumstock, dartproductstock, darthsncode, dartgst, dartproductstockstatus from  dartproductmaster "
			+ "WHERE LOWER(trim(dartproductstockstatus)) = LOWER(trim('out of stock')) LIMIT ?1, 6")
	List<Dartproductmaster> getAllOutofstockProducts(Integer startindx);
	
}
