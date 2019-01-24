package com.pcdgroup.cms.PcdEcom.MyAccount;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyaccountRepository extends CrudRepository<Myaccountmaster, Integer> {

	@Query(nativeQuery = true, value = "Select r.fname, r.lname, r.email, r.mobileno, "
			+ "m.myaccountid, m.userid, m.shippingaddress, m.currentaddress, m.organizationname, m.alternateemail, m.alternatemobileno, m.currentcity, m.currentstate, m.currentpincode, m.shippingcity, m.shippingstate, m.shippingpincode "
			+ "from  myaccountmaster m "
			+ "INNER JOIN registermaster r ON m.userid = r.rid "
			+ "WHERE r.rid = ?1")
	List<Myaccountmaster> getMyAccountDetails(Integer rid);
	
	@Query(nativeQuery = true, value = "SELECT myaccountid FROM myaccountmaster ORDER BY myaccountid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT myaccountid FROM myaccountmaster WHERE userid = ?1")
	Integer getUpdateRowId(Integer userid);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "DELETE FROM myaccountmaster WHERE userid = ?1")
	Integer getDeleteRowId(Integer userid);
}
