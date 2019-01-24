package com.pcdgroup.cms.PcdEcom.Dealor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dealormaster")
public class Dealormaster {

	@Id
	@Column(name="dealorid") 
	private Integer dealorid; 
	
	@Column(name="dealorfname")
	private String dealorfname; 
	
	@Column(name="dealorlname")
	private String dealorlname; 
	
	@Column(name="dealornumber")
	private String dealornumber; 
	
	@Column(name="dealoremail")
	private String dealoremail; 
	
	@Column(name="dealorpassword")
	private String dealorpassword; 
	
	@Column(name="dealorproductbrand")
	private String dealorproductbrand;
	
	@Column(name="dealoraddress")
	private String dealoraddress;

	
	public Dealormaster() {
		super();
	}

	public Dealormaster(Integer dealorid, String dealorfname, String dealorlname, String dealornumber,
			String dealoremail, String dealorpassword, String dealorproductbrand, String dealoraddress) {
		super();
		this.dealorid = dealorid;
		this.dealorfname = dealorfname;
		this.dealorlname = dealorlname;
		this.dealornumber = dealornumber;
		this.dealoremail = dealoremail;
		this.dealorpassword = dealorpassword;
		this.dealorproductbrand = dealorproductbrand;
		this.dealoraddress = dealoraddress;
	}

	public Integer getDealorid() {
		return dealorid;
	}

	public void setDealorid(Integer dealorid) {
		this.dealorid = dealorid;
	}

	public String getDealorfname() {
		return dealorfname;
	}

	public void setDealorfname(String dealorfname) {
		this.dealorfname = dealorfname;
	}

	public String getDealorlname() {
		return dealorlname;
	}

	public void setDealorlname(String dealorlname) {
		this.dealorlname = dealorlname;
	}

	public String getDealornumber() {
		return dealornumber;
	}

	public void setDealornumber(String dealornumber) {
		this.dealornumber = dealornumber;
	}

	public String getDealoremail() {
		return dealoremail;
	}

	public void setDealoremail(String dealoremail) {
		this.dealoremail = dealoremail;
	}

	public String getDealorpassword() {
		return dealorpassword;
	}

	public void setDealorpassword(String dealorpassword) {
		this.dealorpassword = dealorpassword;
	}
	
	public String getDealorproductbrand() {
		return dealorproductbrand;
	}

	public void setDealorproductbrand(String dealorproductbrand) {
		this.dealorproductbrand = dealorproductbrand;
	}

	public String getDealoraddress() {
		return dealoraddress;
	}

	public void setDealoraddress(String dealoraddress) {
		this.dealoraddress = dealoraddress;
	}
	
}
