package com.pcdgroup.cms.PcdEcom.Addtocart;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddtocartRepository extends CrudRepository<Addtocartmaster, Integer> {
//WHERE userid = ?1 LIMIT 6
	@Query(nativeQuery = true, value = "Select "
			+ "a.addcartid, a.dpid, a.dsid, a.ppid, a.psid, a.userid, a.vendorid, a.numberofproducts, a.totalamount, a.addcartdatetime, a.addtocartbrand, a.addtocarttype, "
			+ "p.productname, p.productimage, p.producttype, p.productprice, p.productminimumstock, p.productstock, p.hsncode, p.gst, "
			+ "s.pcdservicename, s.pcdserviceperunit, s.pcdserviceduration, s.pcdserviceprice, s.pcdservicehsncode, s.pcdservicegst, s.pcdservicestatus, s.pcdserviceimage, "
			+ "dp.dartproductname, dp.dartproductimage, dp.dartproducttype, dp.dartproductprice, dp.dartproductminimumstock, dp.dartproductstock, dp.darthsncode, dp.dartgst, "
			+ "ds.dartservicename, ds.dartserviceperunit, ds.dartserviceduration, ds.dartserviceprice, ds.dartservicehsncode, ds.dartservicegst, ds.dartservicestatus, ds.dartserviceimage from  addtocartmaster a "
			+ "LEFT JOIN pcdproductmaster p ON p.productid = a.dpid  "
			+ "LEFT JOIN pcdservicemaster s ON s.pcdserviceid = a.psid "
			+ "LEFT JOIN dartproductmaster dp ON dp.dartproductid = a.dpid "
			+ "LEFt JOIN dartservicemaster ds ON ds.dartserviceid = a.dsid "
			+ "WHERE a.userid = ?1"
			)
	List<?> getAllOrders(Integer id);
	
	@Query(nativeQuery = true, value = "Select addcartid, userid, dpid, dsid, ppid, psid, vendorid, numberofproducts, totalamount, addcartdatetime, addtocartbrand, addtocarttype "
			+ "from  addtocartmaster WHERE userid = ?1 "
			+ "ORDER BY addcartid DESC LIMIT 0, 10")
	List<Addtocartmaster> getAllCartItems(Integer id);
	
	@Query(nativeQuery = true, value = "SELECT addcartid FROM addtocartmaster ORDER BY addcartid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT addcartid FROM addtocartmaster WHERE userid = ?1 AND dpid = ?2 LIMIT 0, 1")
	Integer getExistDartproductItemId(Integer userid, Integer dpid);
	
	@Query(nativeQuery = true, value = "SELECT addcartid FROM addtocartmaster WHERE userid = ?1 AND dsid = ?2 LIMIT 0, 1")
	Integer getExistDartserviceItemId(Integer userid, Integer dsid);
	
	@Query(nativeQuery = true, value = "SELECT addcartid FROM addtocartmaster WHERE userid = ?1 AND ppid = ?2 LIMIT 0, 1")
	Integer getExistPcdproductItemId(Integer userid, Integer ppid);
	
	@Query(nativeQuery = true, value = "SELECT addcartid FROM addtocartmaster WHERE userid = ?1 AND psid = ?2 LIMIT 0, 1")
	Integer getExistPcdserviceItemId(Integer userid, Integer psid);
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "DELETE FROM addtocartmaster WHERE userid = ?1 AND addcartid = ?2 ")
	Integer deleteCartItem(Integer id, Integer itemid);
	
}
