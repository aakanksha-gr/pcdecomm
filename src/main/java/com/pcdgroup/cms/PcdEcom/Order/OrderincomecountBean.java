package com.pcdgroup.cms.PcdEcom.Order;

public class OrderincomecountBean {

	String date;
	String month;
	String year;
	String totalincome;
	
	
	public OrderincomecountBean() {
		super();
	}
	
	public OrderincomecountBean(String date, String month, String year, String totalincome) {
		super();
		this.date = date;
		this.month = month;
		this.year = year;
		this.totalincome = totalincome;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getTotalincome() {
		return totalincome;
	}

	public void setTotalincome(String totalincome) {
		this.totalincome = totalincome;
	}
	
}
