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
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster LIMIT ?1, 10")
	List<Employeetaskmaster> getAllEmployeetask(Integer index);
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE trim(LOWER(taskstatus)) = trim(LOWER('pending'))")
	List<Employeetaskmaster> getAllEmployeependingtask();
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE trim(LOWER(taskstatus)) = trim(LOWER('completed'))")
	List<Employeetaskmaster> getAllEmployeecompletedtask();
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE trim(LOWER(taskstatus)) = trim(LOWER('pending')) AND employeetaskempid =  ?1")
	List<Employeetaskmaster> getAllEmployeependingtaskByEmpid(Integer empid);

	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE trim(LOWER(taskstatus)) = trim(LOWER('completed')) AND employeetaskempid =  ?1")
	List<Employeetaskmaster> getEmployeeCompletedtaskByEmpid(Integer empid);
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE taskdeadline < DATE(NOW()) AND trim(LOWER(taskstatus)) = trim(LOWER('pending')) AND employeetaskempid = ?1")
	List<Employeetaskmaster> getAllEmployeependingtaskCrossedDeadlineByEmpid(Integer empid); 
	
	@Query(nativeQuery = true, value = "SELECT count(employeetaskid) from employeetaskmaster where trim(LOWER(taskstatus)) = trim(LOWER('pending'))")
	Integer countTotalNoOfPendingTasks();
	
	@Query(nativeQuery = true, value = "SELECT count(employeetaskid) from employeetaskmaster where trim(LOWER(taskstatus)) = trim(LOWER('completed'))")
	Integer countTotalNoOfCompletedTasks();
	
	@Query(nativeQuery = true, value = "SELECT count(employeetaskid) from employeetaskmaster where trim(LOWER(taskstatus)) = trim(LOWER('pending')) AND employeetaskempid = ?1")
	Integer countTotalNoOfPendingTasksByEmpid(Integer empid);
	
	@Query(nativeQuery = true, value = "SELECT count(employeetaskid) from employeetaskmaster where trim(LOWER(taskstatus)) = trim(LOWER('completed')) AND employeetaskempid = ?1")
	Integer countTotalNoOfCompletedTasksEmpid(Integer empid);
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE taskdeadline < DATE(NOW()) AND trim(LOWER(taskstatus)) = trim(LOWER('pending'))")
	List<Employeetaskmaster> getAllEmployeependingtaskByDeadline();
	
	@Query(nativeQuery = true, value = "SELECT employeetaskid, employeetaskempid, taskidemployeetask, taskdatetime, taskdeadline, taskstatus FROM employeetaskmaster WHERE employeetaskempid = ?1 LIMIT ?2, 10")
	List<Employeetaskmaster> getEmployeetaskByEmpid(Integer empid, Integer index);
	
}
