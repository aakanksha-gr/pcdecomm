package com.pcdgroup.cms.PcdEcom.Addtocart;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="addtocartmaster")
public class Addtocartmaster {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="addcartid")
	private Integer addcartid;
	
	@Column(name="dpid") 
	private Integer dpid;
	
	@Column(name="dsid")
	private Integer dsid;
	
	@Column(name="ppid")
	private Integer ppid;
	
	@Column(name="psid")
	private Integer psid;
	
	@Column(name="userid")
	private Integer userid;
	
	@Column(name="vendorid")
	private Integer vid;
	
	@Column(name="numberofproducts")
	private Integer totalproducts;
	
	@Column(name="totalamount")
	private Integer totalprice;
	
	@Column(name="addcartdatetime")
	private Date datetime;
	
	@Column(name="addtocartbrand") 
	private String addcartbrand;
	
	@Column(name="addtocarttype")
	private String addcarttype;

	public Addtocartmaster() {
		
	}

	public Addtocartmaster(Integer addcartid, Integer dpid, Integer dsid, Integer ppid, Integer psid, Integer userid,
			Integer vid, Integer totalproducts, Integer totalprice, Date datetime, String addcartbrand,
			String addcarttype) {
		super();
		this.addcartid = addcartid;
		this.dpid = dpid;
		this.dsid = dsid;
		this.ppid = ppid;
		this.psid = psid;
		this.userid = userid;
		this.vid = vid;
		this.totalproducts = totalproducts;
		this.totalprice = totalprice;
		this.datetime = datetime;
		this.addcartbrand = addcartbrand;
		this.addcarttype = addcarttype;
	}

	public Integer getAddcartid() {
		return addcartid;
	}

	public void setAddcartid(Integer addcartid) {
		this.addcartid = addcartid;
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

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
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

	public Date getDatetime() {
		return datetime;
	}

	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}

	public String getAddcartbrand() {
		return addcartbrand;
	}

	public void setAddcartbrand(String addcartbrand) {
		this.addcartbrand = addcartbrand;
	}

	public String getAddcarttype() {
		return addcarttype;
	}

	public void setAddcarttype(String addcarttype) {
		this.addcarttype = addcarttype;
	}
	
}
