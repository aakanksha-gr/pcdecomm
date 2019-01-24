package com.pcdgroup.cms.PcdEcom.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeemaster")
public class Employeemaster {

	@Id
	@Column(name="employeeid") 
	private Integer employeeid;
	
	@Column(name="employeefname")
	private String employeefname;
	
	@Column(name="employeelname")
	private String employeelname;
	
	@Column(name="employeedesignation")
	private String employeedesignation;

	@Column(name="employeeworkingbrand")
	private String employeeworkingbrand;
	
	@Column(name="employeeworkingtype")
	private String employeeworkingtype;
	
	@Column(name="employeeemail") 
	private String employeeemail;
	
	@Column(name="employeepassword")
	private String employeepassword;
	
	@Column(name="employeecontactno") 
	private String employeecontactno;
	
	@Column(name="employeeaddress")
	private String employeeaddress;

	public Employeemaster() {
		super();
	}

	public Employeemaster(Integer employeeid, String employeefname, String employeelname, String employeedesignation,
			String employeeworkingbrand, String employeeworkingtype, String employeeemail, String employeepassword, String employeecontactno,
			String employeeaddress) {
		super();
		this.employeeid = employeeid;
		this.employeefname = employeefname;
		this.employeelname = employeelname;
		this.employeedesignation = employeedesignation;
		this.employeeworkingbrand = employeeworkingbrand;
		this.employeeemail = employeeemail;
		this.employeepassword = employeepassword;
		this.employeecontactno = employeecontactno;
		this.employeeaddress = employeeaddress;
		this.employeeworkingtype = employeeworkingtype;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public String getEmployeefname() {
		return employeefname;
	}

	public void setEmployeefname(String employeefname) {
		this.employeefname = employeefname;
	}

	public String getEmployeelname() {
		return employeelname;
	}

	public void setEmployeelname(String employeelname) {
		this.employeelname = employeelname;
	}

	public String getEmployeedesignation() {
		return employeedesignation;
	}

	public void setEmployeedesignation(String employeedesignation) {
		this.employeedesignation = employeedesignation;
	}

	public String getEmployeeworkingbrand() {
		return employeeworkingbrand;
	}

	public void setEmployeeworkingbrand(String employeeworkingbrand) {
		this.employeeworkingbrand = employeeworkingbrand;
	}

	public String getEmployeeemail() {
		return employeeemail;
	}

	public void setEmployeeemail(String employeeemail) {
		this.employeeemail = employeeemail;
	}

	public String getEmployeepassword() {
		return employeepassword;
	}

	public void setEmployeepassword(String employeepassword) {
		this.employeepassword = employeepassword;
	}

	public String getEmployeecontactno() {
		return employeecontactno;
	}

	public void setEmployeecontactno(String employeecontactno) {
		this.employeecontactno = employeecontactno;
	}

	public String getEmployeeaddress() {
		return employeeaddress;
	}

	public void setEmployeeaddress(String employeeaddress) {
		this.employeeaddress = employeeaddress;
	}

	public String getEmployeeworkingtype() {
		return employeeworkingtype;
	}

	public void setEmployeeworkingtype(String employeeworkingtype) {
		this.employeeworkingtype = employeeworkingtype;
	}
	
}
