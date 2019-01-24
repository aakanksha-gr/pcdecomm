package com.pcdgroup.cms.PcdEcom.Order;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ordermaster")
public class Ordermaster {

	@Id
	@Column(name="orderid")
	private Integer oid;
	
	@Column(name="rid")
	private Integer rid;
	
	@Column(name="ppid")
	private Integer ppid;
	
	@Column(name="psid")
	private Integer psid;  
	
	@Column(name="dpid")
	private Integer dpid;
	
	@Column(name="dsid")
	private Integer dsid;
	
	@Column(name="vendorid")
	private Integer vid;
	
	@Column(name="totalproducts")
	private Integer totalproducts;
	
	@Column(name="totalprice")
	private Integer totalprice;
	
	@Column(name="orderdatetime")
	private Date orderdatetime;
	
	@Column(name="ordercategory")
	private String ordercategory;
	
	@Column(name="orderstatus")
	private String orderstatus;
	
	@Column(name="orderbrand") 
	private String orderbrand; 
	
	@Column(name="ordertype")
	private String ordertype;
	
	
	public Ordermaster() {
		
	}
	
	public Ordermaster(Integer oid, Integer rid, Integer ppid, Integer psid, Integer dpid, Integer dsid, Integer vid,
			Integer totalproducts, Integer totalprice, Date orderdatetime, String ordercategory,
			String orderstatus, String ordertype, String orderbrand) {
		super();
		this.oid = oid;
		this.rid = rid;
		this.ppid = ppid;
		this.psid = psid;
		this.dpid = dpid;
		this.dsid = dsid;
		this.vid = vid;
		this.totalproducts = totalproducts;
		this.totalprice = totalprice;
		this.orderdatetime = orderdatetime;
		this.ordercategory = ordercategory;
		this.orderstatus = orderstatus;
		this.orderbrand = orderbrand;
		this.ordertype = ordertype;
	}

	public Integer getOid() {
		return oid;
	}

	public void setOid(Integer oid) {
		this.oid = oid;
	}

	public Integer getRid() {
		return rid;
	}

	public void setRid(Integer rid) {
		this.rid = rid;
	}

	public Integer getPpid() {
		return ppid;
	}

	public void setPpid(Integer ppid) {
		this.ppid = ppid;
	}

	public Integer getPsid() {
		return psid;
	}

	public void setPsid(Integer psid) {
		this.psid = psid;
	}

	public Integer getDpid() {
		return dpid;
	}

	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}

	public Integer getDsid() {
		return dsid;
	}

	public void setDsid(Integer dsid) {
		this.dsid = dsid;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public Integer getTotalproducts() {
		return totalproducts;
	}

	public void setTotalproducts(Integer totalproducts) {
		this.totalproducts = totalproducts;
	}

	public Integer getTotalprice() {
		return totalprice;
	}

	public void setTotalprice(Integer totalprice) {
		this.totalprice = totalprice;
	}
	
	public Date getOrderdatetime() {
		return orderdatetime;
	}

	public void setOrderdatetime(Date orderdatetime) {
		this.orderdatetime = orderdatetime;
	}

	public String getOrdercategory() {
		return ordercategory;
	}

	public void setOrdercategory(String ordercategory) {
		this.ordercategory = ordercategory;
	}

	public String getOrderstatus() {
		return orderstatus;
	}

	public void setOrderstatus(String orderstatus) {
		this.orderstatus = orderstatus;
	}

	public String getOrderbrand() {
		return orderbrand;
	}

	public void setOrderbrand(String orderbrand) {
		this.orderbrand = orderbrand;
	}

	public String getOrdertype() {
		return ordertype;
	}

	public void setOrdertype(String ordertype) {
		this.ordertype = ordertype;
	}
	
}
