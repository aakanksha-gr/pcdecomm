package com.pcdgroup.cms.PcdEcom.Employeelogin;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeeloginmaster")
public class Employeeloginmaster {

	@Id
	@Column(name="employeeliginid")
	private Integer employeeliginid; 
	
	@Column(name="empid")
	private Integer empid; 
	
	@Column(name="servicestartingtime")
	private Date servicestartingtime;
	
	@Column(name="location")
	private String location;
	
	
	public Employeeloginmaster() {
		super();
	}

	public Employeeloginmaster(Integer employeeliginid, Integer empid, Date servicestartingtime, String location) {
		super();
		this.employeeliginid = employeeliginid;
		this.empid = empid;
		this.servicestartingtime = servicestartingtime;
		this.location = location;
	}

	public Integer getEmployeeliginid() {
		return employeeliginid;
	}

	public void setEmployeeliginid(Integer employeeliginid) {
		this.employeeliginid = employeeliginid;
	}

	public Integer getEmpid() {
		return empid;
	}

	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public Date getServicestartingtime() {
		return servicestartingtime;
	}

	public void setServicestartingtime(Date servicestartingtime) {
		this.servicestartingtime = servicestartingtime;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
}
