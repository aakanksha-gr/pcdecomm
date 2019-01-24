package com.pcdgroup.cms.PcdEcom.PcdService;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServiceRepository extends CrudRepository<Servicemaster, Integer> {

	@Query(nativeQuery = true, value = "Select pcdserviceid, pcdservicename, pcdserviceperunit, pcdserviceduration, pcdserviceprice, pcdservicehsncode, pcdservicegst, pcdservicestatus, pcdserviceimage from  pcdservicemaster LIMIT ?1, 6")
	List<Servicemaster> getAllPcdServices(Integer startIndex);
	
	@Query(nativeQuery = true, value = "Select pcdserviceid, pcdservicename, pcdserviceperunit, pcdserviceduration, pcdserviceprice, pcdservicehsncode, pcdservicegst, pcdservicestatus, pcdserviceimage from  pcdservicemaster WHERE pcdserviceid = ?1")
	List<Servicemaster> getPcdServiceById(Integer serviceid);
	
	@Query(nativeQuery = true, value = "SELECT pcdserviceid FROM pcdservicemaster ORDER BY pcdserviceid DESC LIMIT 0, 1")
	Integer getMaxId();

	@Query(nativeQuery = true, value = "SELECT pcdserviceid FROM pcdservicemaster WHERE pcdserviceid = ?1")
	Integer getServiceId(Integer serviceid);
	
}
