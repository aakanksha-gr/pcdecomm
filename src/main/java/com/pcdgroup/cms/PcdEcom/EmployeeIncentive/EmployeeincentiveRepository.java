package com.pcdgroup.cms.PcdEcom.EmployeeIncentive;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeincentiveRepository extends CrudRepository<EmployeeIncentivemaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT empincentiveid FROM employeeincentivemaster ORDER BY empincentiveid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT empincentiveid, employeeid, incentivedate, incentiveamount FROM employeeincentivemaster WHERE empincentiveid = ?1")
	EmployeeIncentivemaster getEmployeeincentiveById(Integer employeeid);
	
	@Query(nativeQuery = true, value = "SELECT empincentiveid, employeeid, incentivedate, incentiveamount FROM employeeincentivemaster LIMIT ?1, 10")
	List<EmployeeIncentivemaster> getAllEmployeeincentive(Integer index);
	
	@Query(nativeQuery = true, value = "SELECT sum(incentiveamount) from employeeincentivemaster where month(incentivedate) = ?1 AND employeeid = ?2")
	Integer getEmployeeincentiveByMonth(Integer month, Integer empid);	
	
	@Query(nativeQuery = true, value = "SELECT empincentiveid, employeeid, incentivedate, incentiveamount from employeeincentivemaster where month(incentivedate) = month(?1)")
	List<EmployeeIncentivemaster> getAllEmployeeincentiveByMonth(Date incentivedate);	
	
	@Query(nativeQuery = true, value = "SELECT empincentiveid, employeeid, incentivedate, incentiveamount from employeeincentivemaster where year(incentivedate) = year(?1) AND employeeid = ?2")
	List<EmployeeIncentivemaster> getEmployeeincentiveByYear(Date incentivedate, Integer empid);	
	
	@Query(nativeQuery = true, value = "SELECT empincentiveid, employeeid, incentivedate, incentiveamount from employeeincentivemaster where year(incentivedate) = year(?1)")
	List<EmployeeIncentivemaster> getAllEmployeeincentiveByYear(Date incentivedate);
	
}
