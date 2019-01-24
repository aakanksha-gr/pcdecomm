package com.pcdgroup.cms.PcdEcom.DartService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DartServiceRepository extends CrudRepository<Dartservicemaster, Integer> {

	@Query(nativeQuery = true, value = "Select dartserviceid, dartservicename, dartserviceperunit, dartserviceduration, dartserviceprice, dartservicehsncode, dartservicegst, dartservicestatus, dartserviceimage from  dartservicemaster LIMIT ?1, 6")
	List<Dartservicemaster> getAllDartServices(Integer startIndex);

	@Query(nativeQuery = true, value = "Select dartserviceid, dartservicename, dartserviceperunit, dartserviceduration, dartserviceprice, dartservicehsncode, dartservicegst, dartservicestatus, dartserviceimage "
			+ "from  dartservicemaster "
			+ "WHERE dartserviceid = ?1")
	List<Dartservicemaster> getDartServiceById(Integer serviceid);
	
	@Query(nativeQuery = true, value = "SELECT dartserviceid FROM dartservicemaster ORDER BY dartserviceid DESC LIMIT 0, 1")
	Integer getMaxId();

	@Query(nativeQuery = true, value = "SELECT dartserviceid FROM dartservicemaster WHERE dartserviceid = ?1")
	Integer getServiceId(Integer serviceid);
	
}
