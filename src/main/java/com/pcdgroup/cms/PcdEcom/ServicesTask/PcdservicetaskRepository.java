package com.pcdgroup.cms.PcdEcom.ServicesTask;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PcdservicetaskRepository extends CrudRepository<Pcdservicetaskmaster, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT pcdservicetaskid FROM pcdservicetaskmaster ORDER BY pcdservicetaskid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT pcdservicetaskid, pcdsid, pstaskid FROM pcdservicetaskmaster WHERE pcdservicetaskid = ?1")
	Pcdservicetaskmaster getPcdserviceTask(Integer pcdservicetaskid);

	@Query(nativeQuery = true, value = "SELECT pcdservicetaskid, pcdsid, pstaskid FROM pcdservicetaskmaster")
	List<Pcdservicetaskmaster> getAllPcdserviceTask();

	@Query(nativeQuery = true, value = "SELECT pcdservicetaskid, pcdsid, pstaskid FROM pcdservicetaskmaster WHERE pcdsid = ?1")
	List<Pcdservicetaskmaster> getAllPcdserviceByServiceid(Integer pcdserviceid);
	
}
