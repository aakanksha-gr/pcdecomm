package com.pcdgroup.cms.PcdEcom.BasicRegistration;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="registermaster")
public class Registermaster {
	
	@Id
	@Column(name="rid")
	private Integer rid;
	
	@Column(name="fname")
	private String fname;
	
	@Column(name="lname")
	private String lname;
	
	@Column(name="email")
	private String email;
	
	@Column(name="mobileno")
	private String mobileno;
	
	@Column(name="password")
	private String password;
	
	@Column(name="confirmpassword")
	private String confirmpassword;
	
	public Registermaster() {
		
	}
	
	public Registermaster(Integer rid, String fname, String lname, String email, String mobileno, String password,
			String confirmpassword) {
		super();
		this.rid = rid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.mobileno = mobileno;
		this.password = password;
		this.confirmpassword = confirmpassword;
	}

	public Integer getId() {
		return rid;
	}

	public void setId(Integer rid) {
		this.rid = rid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmpassword() {
		return confirmpassword;
	}

	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}

}
