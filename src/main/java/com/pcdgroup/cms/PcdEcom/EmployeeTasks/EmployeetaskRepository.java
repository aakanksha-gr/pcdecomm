package com.pcdgroup.cms.PcdEcom.EmployeeTasks;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeetaskRepository extends CrudRepository<Employeetaskmaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT employeetaskid FROM employeetaskmaster ORDER BY employeetaskid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE employeetaskid = ?1")
	Employeetaskmaster getEmployeetask(Integer emptaskid);
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster")
	List<Employeetaskmaster> getAllEmployeetask();
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE LOWER(taskstatus) = LOWER('pending')")
	List<Employeetaskmaster> getAllEmployeependingtask();
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE taskdeadline < DATE(NOW()) AND LOWER(taskstatus) = LOWER('pending')")
	List<Employeetaskmaster> getAllEmployeependingtaskByDeadline();
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE employeetaskempid = ?1")
	List<Employeetaskmaster> getEmployeetaskByEmpid(Integer empid);
	
}
