package com.pcdgroup.cms.PcdEcom.BasicRegistration;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegisterRepository extends CrudRepository<Registermaster, Integer>{
	
	@Modifying
	@Query(nativeQuery = true, value = "Delete from registermaster where id = ?1")
	Integer deleteUr(Integer id);
	
	@Query(nativeQuery = true, value = "Select rid, fname, lname, email, mobileno, password, confirmpassword from registermaster where email = ?1 and password = ?2")
	Registermaster loginid(String email, String password);
	
	@Query(nativeQuery = true, value = "Select rid, fname from registermaster where LOWER(email) = LOWER(?1) and rid <> ?2")
	List<Registermaster> duplicateEmailList(String email, Integer rid);
	
	@Query(nativeQuery = true, value = "SELECT rid FROM registermaster ORDER BY rid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "Select rid, fname, lname, email, mobileno, password, confirmpassword from  registermaster LIMIT ?1 , 6")
	List<Registermaster> getUsersList(Integer startIndex);
	
	@Query(nativeQuery = true, value = "SELECT rid FROM registermaster WHERE rid = ?1")
	Integer getDeletedUserId(Integer id);
	
	@Query(nativeQuery = true, value = "Select email from registermaster where email = ?1")
	List<?> findEmail(String email);
	
	@Query(nativeQuery = true, value = "SELECT rid, fname, lname, email, mobileno, password, confirmpassword FROM registermaster WHERE rid = ?1")
	Registermaster getUserDetailsById(Integer userid);
	
}
