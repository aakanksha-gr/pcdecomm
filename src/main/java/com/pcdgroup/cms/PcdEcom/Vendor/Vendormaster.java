package com.pcdgroup.cms.PcdEcom.Vendor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendormaster")
public class Vendormaster {

	@Id
	@Column(name="vendorid") 
	private Integer vendorid;
	
	@Column(name="vendorfname")
	private String vendorfname;
	
	@Column(name="vendorlname")
	private String vendorlname;
	
	@Column(name="vendorproductbrand")
	private String vendorproductbrand;
	
	@Column(name="vendoremail")
	private String vendoremail;
	
	@Column(name="vendorcontactno")
	private String vendorcontactno;
	
	@Column(name="vendoraddress")
	private String vendoraddress;

	@Column(name="vendorpassword")
	private String vendorpassword;
	
	public Vendormaster() {
		super();
	}

	public Vendormaster(Integer vendorid, String vendorfname, String vendorlname, String vendoremail,
			String vendorcontactno, String vendoraddress, String vendorpassword, String vendorproductbrand) {
		super();
		this.vendorid = vendorid;
		this.vendorfname = vendorfname;
		this.vendorlname = vendorlname;
		this.vendoremail = vendoremail;
		this.vendorcontactno = vendorcontactno;
		this.vendoraddress = vendoraddress;
		this.vendorpassword = vendorpassword;
		this.vendorproductbrand = vendorproductbrand;
		
	}

	public Integer getVendorid() {
		return vendorid;
	}

	public void setVendorid(Integer vendorid) {
		this.vendorid = vendorid;
	}

	public String getVendorfname() {
		return vendorfname;
	}

	public void setVendorfname(String vendorfname) {
		this.vendorfname = vendorfname;
	}

	public String getVendorlname() {
		return vendorlname;
	}

	public void setVendorlname(String vendorlname) {
		this.vendorlname = vendorlname;
	}

	public String getVendoremail() {
		return vendoremail;
	}

	public void setVendoremail(String vendoremail) {
		this.vendoremail = vendoremail;
	}

	public String getVendorcontactno() {
		return vendorcontactno;
	}

	public void setVendorcontactno(String vendorcontactno) {
		this.vendorcontactno = vendorcontactno;
	}

	public String getVendoraddress() {
		return vendoraddress;
	}

	public void setVendoraddress(String vendoraddress) {
		this.vendoraddress = vendoraddress;
	}

	public String getVendorpassword() {
		return vendorpassword;
	}

	public void setVendorpassword(String vendorpassword) {
		this.vendorpassword = vendorpassword;
	}

	public String getVendorproductbrand() {
		return vendorproductbrand;
	}

	public void setVendorproductbrand(String vendorproductbrand) {
		this.vendorproductbrand = vendorproductbrand;
	}
	
}
