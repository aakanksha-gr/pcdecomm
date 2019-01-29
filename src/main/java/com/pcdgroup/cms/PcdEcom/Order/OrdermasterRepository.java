package com.pcdgroup.cms.PcdEcom.Order;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdermasterRepository extends CrudRepository<Ordermaster, Integer> {
	
	@Query(nativeQuery = true, value = "Select orderid,orderdatetime,dpid,dsid,ordercategory,orderstatus,ppid,psid,rid,totalprice,totalproducts,vendorid, orderbrand, ordertype from  ordermaster WHERE orderid = ?1")
	List<Ordermaster> getOrderById(Integer id);
	
	@Query(nativeQuery = true, value = "Select orderid,orderdatetime,dpid,dsid,ordercategory,orderstatus,ppid,psid,rid,totalprice,totalproducts,vendorid, orderbrand, ordertype from  ordermaster WHERE orderid = ?1 ORDER BY orderid DESC LIMIT 0, 10")
	List<Ordermaster> getAllOrders(Integer index);
	
	@Query(nativeQuery = true, value = "Select orderid,orderdatetime,dpid,dsid,ordercategory,orderstatus,ppid,psid,rid,totalprice,totalproducts,vendorid, orderbrand, ordertype from  ordermaster ORDER BY orderdatetime DESC LIMIT ?1, 10")
	List<Ordermaster> getAllOrdersByMonths(Integer index);
	
	@Query(nativeQuery = true, value = "SELECT orderid FROM ordermaster ORDER BY orderid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Modifying
	@Transactional
	@Query(nativeQuery = true, value = "DELETE FROM ordermaster WHERE orderid = ?1 AND rid = ?2")
	void cancleOrder(Integer orderid, Integer userid);
	
	@Query(nativeQuery = true, value = "Select orderid,orderdatetime,dpid,dsid,ordercategory,orderstatus,ppid,psid,rid,totalprice,totalproducts,vendorid, orderbrand, ordertype from  ordermaster WHERE LOWER(trim(orderbrand = LOWER(trim(?1)))) LIMIT 10")
	List<Ordermaster> getAllOrdersByBrand(String brand);
	
	@Query(nativeQuery = true, value = "SELECT orderid,orderdatetime,dpid,dsid,ordercategory,orderstatus,ppid,psid,rid,totalprice,totalproducts,vendorid, orderbrand, ordertype from  ordermaster "
			+ "WHERE LOWER(trim(orderstatus)) = LOWER(trim('pending')) LIMIT ?1, 6")
	List<Ordermaster> getAllPendingorders(Integer startindx);
	
	@Query(nativeQuery = true, value = "Select o.orderid, o.orderdatetime, o.dpid, o.dsid, o.ordercategory, o.orderstatus, o.ppid, o.psid, o.rid, o.totalprice, o.totalproducts, o.vendorid, o.orderbrand, o.ordertype, "
			+ "m.myaccountid, m.userid, m.shippingaddress, m.currentaddress, m.organizationname, m.alternateemail, m.alternatemobileno, m.currentcity, m.currentstate, m.currentpincode, m.shippingcity, m.shippingstate, m.shippingpincode  "
			+ "from  ordermaster o "
			+ "INNER JOIN myaccountmaster m ON m.userid = o.rid "
			+ "WHERE o.rid = ?1 LIMIT 10")
	List<?> getOrderWithUserDetails(Integer userid);
	
	@Query(nativeQuery = true, value = "SELECT orderid, orderdatetime, dpid, dsid, ordercategory, orderstatus, ppid, psid, rid, totalprice, totalproducts, vendorid, orderbrand, ordertype from  ordermaster"
			+ " where month(orderdatetime) = ?1 AND year(orderdatetime) = ?2 ORDER BY orderid ASC LIMIT 10")
	List<Ordermaster> getTotalIncomeByMonthYear(Integer month, Integer year);
	
	@Query(nativeQuery = true, value = "SELECT sum(totalprice) from ordermaster where month(orderdatetime) = ?1 and year(orderdatetime) = ?2 and orderstatus = 'completed'")
	Integer getTotalSumOfIncomeByMonthYear(Integer month, Integer year);

	@Query(nativeQuery = true, value = "SELECT sum(totalprice) from ordermaster where year(orderdatetime) = ?1 and orderstatus = 'completed'")
	Integer getTotalSumOfIncomeByYear(Integer year);
	
	@Query(nativeQuery = true, value = "SELECT orderid, orderdatetime, dpid, dsid, ordercategory, orderstatus, ppid, psid, rid, totalprice, totalproducts, vendorid, orderbrand, ordertype from  ordermaster"
			+ " where month(orderdatetime) = ?1 ORDER BY orderid ASC LIMIT 10")
	List<Ordermaster> getTotalOrdersInSingleMonth(String month);
	
	@Query(nativeQuery = true, value = "SELECT dartproductinventorytid from dartproductinventorymaster where dartproductinventorypid = ?1")
	Integer getDartProductInventoryTaskId(Integer productid);
	
	@Query(nativeQuery = true, value = "SELECT pcdproducttaskid from pcdproducttaskmaster where pcdproducttaskid = ?1")
	Integer getPcdProductInventoryTaskId(Integer productid);
	
	@Query(nativeQuery = true, value = "SELECT pcdproductinventorytid FROM pcdproductinventorymaster where pcdproductinventorypid = ?1")
	Integer getProductInventoryTaskId(Integer productid);
	
	@Query(nativeQuery = true, value = "SELECT sum(totalprice) from ordermaster where orderdatetime = ?1")
	String getTotalOrderAmount(Date datetime);
	
}
