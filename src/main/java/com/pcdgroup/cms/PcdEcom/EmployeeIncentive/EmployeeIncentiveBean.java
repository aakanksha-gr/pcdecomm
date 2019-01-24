package com.pcdgroup.cms.PcdEcom.EmployeeIncentive;

public class EmployeeIncentiveBean {

	String month;
	String year;
	String totalincentive;
	String id;
	
	public EmployeeIncentiveBean() {
		super();
	}

	public EmployeeIncentiveBean(String month, String year, String totalincentive, String id) {
		super();
		this.month = month;
		this.year = year;
		this.totalincentive = totalincentive;
		this.id = id;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public String getTotalincentive() {
		return totalincentive;
	}

	public void setTotalincentive(String totalincentive) {
		this.totalincentive = totalincentive;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
