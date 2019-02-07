package com.pcdgroup.cms.PcdEcom.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employeemaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT employeeid FROM employeemaster ORDER BY employeeid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT employeeid, employeefname, employeelname, employeedesignation, employeeworkingbrand, employeeworkingtype, employeeemail, employeepassword, employeecontactno, employeeaddress FROM employeemaster WHERE LOWER(trim(employeeemail)) = LOWER(trim(?1))")
	Employeemaster checkDuplicateEmail(String email);
	
	@Query(nativeQuery = true, value = "SELECT employeeid, employeefname, employeelname, employeedesignation, employeeworkingbrand, employeeworkingtype, employeeemail, employeepassword, employeecontactno, employeeaddress FROM employeemaster WHERE LOWER(trim(employeeemail)) = LOWER(trim(?1)) and employeeid <> ?2")
	Employeemaster checkDuplicateEmail(String email, Integer employeeid);
	
	@Query(nativeQuery = true, value = "SELECT employeeid, employeefname, employeelname, employeedesignation, employeeworkingbrand, employeeworkingtype, employeeemail, employeepassword, employeecontactno, employeeaddress FROM employeemaster LIMIT ?1, 10")
	List<Employeemaster> getAllEmploiees(Integer index);
	
	@Query(nativeQuery = true, value = "SELECT employeeid, employeefname, employeelname, employeedesignation, employeeworkingbrand, employeeworkingtype, employeeemail, employeepassword, employeecontactno, employeeaddress FROM employeemaster WHERE LOWER(trim(employeeworkingbrand)) = LOWER(trim(?1)) LIMIT 10")
	List<Employeemaster> getAllEmploieesByBrand(String brand);
	
	@Query(nativeQuery = true, value = "SELECT employeeid, employeefname, employeelname, employeedesignation, employeeworkingbrand, employeeworkingtype, employeeemail, employeepassword, employeecontactno, employeeaddress FROM employeemaster WHERE employeeid = ?1")
	Employeemaster getEmployee(Integer employeeid);
		
	@Query(nativeQuery = true, value = "SELECT employeeid, employeefname, employeelname, employeedesignation, employeeworkingbrand, employeeworkingtype, employeeemail, employeepassword, employeecontactno, employeeaddress FROM employeemaster WHERE LOWER(trim(employeeworkingbrand)) = LOWER(trim(?1)) AND LOWER(trim(employeeworkingtype)) = LOWER(trim(?2)) LIMIT ?3, 10")
	List<Employeemaster> getEmployeeByWorkingArea(String employeeworkingbrand, String employeeworkingtype, Integer index);

	@Query(nativeQuery = true, value = "SELECT employeeid, employeefname, employeelname, employeedesignation, employeeworkingbrand, employeeworkingtype, employeeemail, employeepassword, employeecontactno, employeeaddress FROM employeemaster WHERE LOWER(trim(employeeemail)) = ?1 and LOWER(trim(employeepassword)) = ?2 LIMIT 0, 1")
	Employeemaster checkEmployeeLogin(String employeeemail, String employeepassword);
	
	@Query(nativeQuery = true, value = "SELECT count(employeeid) from employeemaster where trim(LOWER(employeeworkingbrand)) = trim(LOWER('pcd')) OR trim(LOWER(employeeworkingbrand)) = trim(LOWER('pcd product'))")
	Integer countTotalNoOfPcdEmployee();
	
	@Query(nativeQuery = true, value = "SELECT count(employeeid) from employeemaster where trim(LOWER(employeeworkingbrand)) = trim(LOWER('dert')) OR trim(LOWER(employeeworkingbrand)) = trim(LOWER('dert product'))")
	Integer countTotalNoOfDartEmployee();
	
}
