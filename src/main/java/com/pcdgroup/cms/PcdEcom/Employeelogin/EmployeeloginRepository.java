package com.pcdgroup.cms.PcdEcom.Employeelogin;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeloginRepository extends CrudRepository<Employeeloginmaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT employeeliginid FROM employeeloginmaster ORDER BY employeeliginid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT employeeliginid, empid, servicestartingtime, location FROM employeeloginmaster ORDER BY employeeliginid DESC LIMIT ?1, 10")
	List<Employeeloginmaster> getAllLoginDetails(Integer index);
	
}
