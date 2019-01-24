package com.pcdgroup.cms.PcdEcom.Admin;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="adminmaster")
public class Adminmaster {
	
	@Id
	@Column(name="adminid")
	private Integer adminid;

	@Column(name="adminfname")
	private String adminfname;
	
	@Column(name="adminlname")
	private String adminlname;
	
	@Column(name="adminemail")
	private String adminemail;
	
	@Column(name="adminpassword")
	private String adminpassword;
	
	@Column(name="admincontactno")
	private String admincontactno;
	
	@Column(name="adminaddress")
	private String adminaddress;

	public Adminmaster() {
		super();
	}

	public Adminmaster(Integer adminid, String adminfname, String adminlname, String adminemail, String adminpassword,
			String admincontactno, String adminaddress) {
		super();
		this.adminid = adminid;
		this.adminfname = adminfname;
		this.adminlname = adminlname;
		this.adminemail = adminemail;
		this.adminpassword = adminpassword;
		this.admincontactno = admincontactno;
		this.adminaddress = adminaddress;
	}

	public Integer getAdminid() {
		return adminid;
	}

	public void setAdminid(Integer adminid) {
		this.adminid = adminid;
	}

	public String getAdminfname() {
		return adminfname;
	}

	public void setAdminfname(String adminfname) {
		this.adminfname = adminfname;
	}

	public String getAdminlname() {
		return adminlname;
	}

	public void setAdminlname(String adminlname) {
		this.adminlname = adminlname;
	}

	public String getAdminemail() {
		return adminemail;
	}

	public void setAdminemail(String adminemail) {
		this.adminemail = adminemail;
	}

	public String getAdminpassword() {
		return adminpassword;
	}

	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}

	public String getAdmincontactno() {
		return admincontactno;
	}

	public void setAdmincontactno(String admincontactno) {
		this.admincontactno = admincontactno;
	}

	public String getAdminaddress() {
		return adminaddress;
	}

	public void setAdminaddress(String adminaddress) {
		this.adminaddress = adminaddress;
	}

}
