package com.pcdgroup.cms.PcdEcom.Bill;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="billmaster")
public class Billmaster {

	@Id
	@Column(name="billid")
	private Integer billid; 
	
	@Column(name="billno")
	private String billno; 
	
	@Column(name="billorderid")
	private Integer billorderid; 

	@Column(name="ordername")
	private String ordername;
	
	@Column(name="orderquantity")
	private String orderquantity; 
	
	@Column(name="billinguserid")
	private Integer billinguserid;
	
	@Column(name="totalamount")
	private String totalamount;
	
	public Billmaster() {
		super();
	}

	public Billmaster(Integer billid, String billno, Integer billorderid, String ordername, String orderquantity,
			Integer billinguserid, String totalamount) {
		super();
		this.billid = billid;
		this.billno = billno;
		this.billorderid = billorderid;
		this.ordername = ordername;
		this.orderquantity = orderquantity;
		this.billinguserid = billinguserid;
		this.totalamount = totalamount;
	}

	public Integer getBillid() {
		return billid;
	}

	public void setBillid(Integer billid) {
		this.billid = billid;
	}

	public String getBillno() {
		return billno;
	}

	public void setBillno(String billno) {
		this.billno = billno;
	}

	public Integer getBillorderid() {
		return billorderid;
	}

	public void setBillorderid(Integer billorderid) {
		this.billorderid = billorderid;
	}

	public String getOrdername() {
		return ordername;
	}

	public void setOrdername(String ordername) {
		this.ordername = ordername;
	}

	public String getOrderquantity() {
		return orderquantity;
	}

	public void setOrderquantity(String orderquantity) {
		this.orderquantity = orderquantity;
	}

	public Integer getBillinguserid() {
		return billinguserid;
	}

	public void setBillinguserid(Integer billinguserid) {
		this.billinguserid = billinguserid;
	}

	public String getTotalamount() {
		return totalamount;
	}

	public void setTotalamount(String totalamount) {
		this.totalamount = totalamount;
	}	
	
}
