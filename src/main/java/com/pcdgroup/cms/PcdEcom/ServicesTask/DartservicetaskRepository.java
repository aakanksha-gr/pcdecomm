package com.pcdgroup.cms.PcdEcom.ServicesTask;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DartservicetaskRepository extends CrudRepository<Dartservicetaskmaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT dartservicetaskid FROM dartservicetaskmaster ORDER BY dartservicetaskid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT dartservicetaskid, dartsid, dartstid FROM dartservicetaskmaster WHERE dartservicetaskid = ?1")
	Dartservicetaskmaster getDartserviceTask(Integer dartservicetaskid);
	
	@Query(nativeQuery = true, value = "SELECT dartservicetaskid, dartsid, dartstid FROM dartservicetaskmaster")
	List<Dartservicetaskmaster> getAllDartserviceTask();

	@Query(nativeQuery = true, value = "SELECT dartservicetaskid, dartsid, dartstid FROM dartservicetaskmaster WHERE dartsid = ?1")
	List<Dartservicetaskmaster> getAllServiceByServiceId(Integer dartserviceid);
	
}
