package com.pcdgroup.cms.PcdEcom.Admin;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AdminRepository extends CrudRepository<Adminmaster, Integer> {

	@Query(nativeQuery = true, value = "SELECT adminid FROM adminmaster ORDER BY adminid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT adminid, adminfname, adminlname, adminemail, adminpassword, admincontactno, adminaddress FROM adminmaster WHERE adminid = ?1")
	Adminmaster getAdminDetails(Integer adminid);
	
	@Query(nativeQuery = true, value = "SELECT adminid, adminfname, adminlname, adminemail, adminpassword, admincontactno, adminaddress FROM adminmaster")
	List<Adminmaster> getAllAdminsDetails();
	
	@Query(nativeQuery = true, value = "SELECT adminid, adminfname, adminlname, adminemail, adminpassword, admincontactno, adminaddress FROM adminmaster WHERE adminemail = ?1")
	Adminmaster checkDuplicateEmail(String email);
	
	@Query(nativeQuery = true, value = "SELECT adminid, adminfname, adminlname, adminemail, adminpassword, admincontactno, adminaddress FROM adminmaster WHERE adminemail = ?1 and adminid <> ?2")
	Adminmaster checkDuplicateEmail(String email, Integer adminid);
	
	@Query(nativeQuery = true, value = "SELECT adminid, adminfname, adminlname, adminemail, adminpassword, admincontactno, adminaddress FROM adminmaster WHERE adminid = ?1")
	Adminmaster checkDeleteIdExist(Integer adminid);
	
	@Query(nativeQuery = true, value = "SELECT adminid, adminfname, adminlname, adminemail, adminpassword, admincontactno, adminaddress FROM adminmaster WHERE trim(LOWER(adminemail)) = ?1 and trim(LOWER(adminpassword)) = ?2 LIMIT 1")
	Adminmaster checkAdminLogin(String adminemail, String adminpassword);
	
}
