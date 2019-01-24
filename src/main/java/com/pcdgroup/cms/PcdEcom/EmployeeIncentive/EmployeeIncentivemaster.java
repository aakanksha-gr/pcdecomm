package com.pcdgroup.cms.PcdEcom.EmployeeIncentive;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeeincentivemaster")
public class EmployeeIncentivemaster {

	@Id
	@Column(name="empincentiveid") 
	private Integer empincentiveid; 
	
	@Column(name="employeeid")
	private Integer employeeid; 
	
	@Column(name="incentivedate")
	private Date incentivedate; 
	
	@Column(name="incentiveamount")
	private String incentiveamount;

	
	public EmployeeIncentivemaster() {
		super();
	}

	public EmployeeIncentivemaster(Integer empincentiveid, Integer employeeid, Date incentivedate,
			String incentiveamount) {
		super();
		this.empincentiveid = empincentiveid;
		this.employeeid = employeeid;
		this.incentivedate = incentivedate;
		this.incentiveamount = incentiveamount;
	}

	public Integer getEmpincentiveid() {
		return empincentiveid;
	}

	public void setEmpincentiveid(Integer empincentiveid) {
		this.empincentiveid = empincentiveid;
	}

	public Integer getEmployeeid() {
		return employeeid;
	}

	public void setEmployeeid(Integer employeeid) {
		this.employeeid = employeeid;
	}

	public Date getIncentivedate() {
		return incentivedate;
	}

	public void setIncentivedate(Date incentivedate) {
		this.incentivedate = incentivedate;
	}

	public String getIncentiveamount() {
		return incentiveamount;
	}

	public void setIncentiveamount(String incentiveamount) {
		this.incentiveamount = incentiveamount;
	}
	
}
