package com.pcdgroup.cms.PcdEcom.MyAccount;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="myaccountmaster")
public class Myaccountmaster {
	
	@Id
	@Column(name="myaccountid")
	private Integer myaccountid;
	
	@Column(name="userid")
	private Integer userid;
	
	@Column(name="shippingaddress") 
	private String shippingaddress; 
	 
	@Column(name="currentaddress")
	private String currentaddress;
	
	@Column(name="organizationname")
	private String organizationname;
	
	@Column(name="alternateemail")
	private String alternateemail;
	
	@Column(name="alternatemobileno")
	private Integer alternatemobileno;

	@Column(name="currentcity")
	private String currentcity;

	@Column(name="currentstate")
	private String currentstate;
	
	@Column(name="currentpincode")
	private String currentpincode;
	
	@Column(name="shippingcity")
	private String shippingcity;
	
	@Column(name="shippingstate")
	private String shippingstate;
	
	@Column(name="shippingpincode")
	private String shippingpincode;
	
	public Myaccountmaster() {
		
	}

	public Myaccountmaster(Integer myaccountid, Integer userid, String shippingaddress, String currentaddress,
			String organizationname, String alternateemail, Integer alternatemobileno, String currentcity,
			String currentstate, String currentpincode, String shippingcity, String shippingstate,
			String shippingpincode) {
		super();
		this.myaccountid = myaccountid;
		this.userid = userid;
		this.shippingaddress = shippingaddress;
		this.currentaddress = currentaddress;
		this.organizationname = organizationname;
		this.alternateemail = alternateemail;
		this.alternatemobileno = alternatemobileno;
		this.currentcity = currentcity;
		this.currentstate = currentstate;
		this.currentpincode = currentpincode;
		this.shippingcity = shippingcity;
		this.shippingstate = shippingstate;
		this.shippingpincode = shippingpincode;
	}

	public Integer getMyaccountid() {
		return myaccountid;
	}

	public void setMyaccountid(Integer myaccountid) {
		this.myaccountid = myaccountid;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getShippingaddress() {
		return shippingaddress;
	}

	public void setShippingaddress(String shippingaddress) {
		this.shippingaddress = shippingaddress;
	}

	public String getCurrentaddress() {
		return currentaddress;
	}

	public void setCurrentaddress(String currentaddress) {
		this.currentaddress = currentaddress;
	}

	public String getOrganizationname() {
		return organizationname;
	}

	public void setOrganizationname(String organizationname) {
		this.organizationname = organizationname;
	}

	public String getAlternateemail() {
		return alternateemail;
	}

	public void setAlternateemail(String alternateemail) {
		this.alternateemail = alternateemail;
	}

	public Integer getAlternatemobileno() {
		return alternatemobileno;
	}

	public void setAlternatemobileno(Integer alternatemobileno) {
		this.alternatemobileno = alternatemobileno;
	}

	public String getCurrentcity() {
		return currentcity;
	}

	public void setCurrentcity(String currentcity) {
		this.currentcity = currentcity;
	}

	public String getCurrentstate() {
		return currentstate;
	}

	public void setCurrentstate(String currentstate) {
		this.currentstate = currentstate;
	}

	public String getCurrentpincode() {
		return currentpincode;
	}

	public void setCurrentpincode(String currentpincode) {
		this.currentpincode = currentpincode;
	}

	public String getShippingcity() {
		return shippingcity;
	}

	public void setShippingcity(String shippingcity) {
		this.shippingcity = shippingcity;
	}

	public String getShippingstate() {
		return shippingstate;
	}

	public void setShippingstate(String shippingstate) {
		this.shippingstate = shippingstate;
	}

	public String getShippingpincode() {
		return shippingpincode;
	}

	public void setShippingpincode(String shippingpincode) {
		this.shippingpincode = shippingpincode;
	}  
	
}
