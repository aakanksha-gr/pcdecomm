package com.pcdgroup.cms.PcdEcom.ProductsTask;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DartproducttaskRepository extends CrudRepository<Dartproducttaskmaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT dartproducttaskid FROM dartproducttaskmaster ORDER BY dartproducttaskid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT dartproducttaskid, dartpid, dartptid FROM dartproducttaskmaster WHERE dartproducttaskid = ?1")
	Dartproducttaskmaster getDartproductTask(Integer dertproducttaskid);
	
	@Query(nativeQuery = true, value = "SELECT dartptid FROM dartproducttaskmaster WHERE dartpid = ?1")
	Integer getTaskIdRelatedToProductId(Integer dartpid);
	
	@Query(nativeQuery = true, value = "SELECT dartproducttaskid, dartpid, dartptid FROM dartproducttaskmaster WHERE dartpid = ?1")
	List<Dartproducttaskmaster> getDartproductTaskByProductid(Integer dertproductid);
	
	@Query(nativeQuery = true, value = "SELECT dartproducttaskid, dartpid, dartptid FROM dartproducttaskmaster")
	List<Dartproducttaskmaster> getAllDartproductTask();
	
}
