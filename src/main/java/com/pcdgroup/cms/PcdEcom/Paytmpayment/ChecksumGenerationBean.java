package com.pcdgroup.cms.PcdEcom.Paytmpayment;

public class ChecksumGenerationBean {
	
	String mid;
	String orderid;
	String custid;
	String industrytypeid;
	String channelid;
	String txnamount;
	String website;
	String callbackurl;
	String email;
	String mobileno;
	
	 
	public ChecksumGenerationBean() {
	
	}


	public ChecksumGenerationBean(String mid, String orderid, String custid, String industrytypeid, String channelid,
			String txnamount, String website, String callbackurl, String email, String mobileno) {
		super();
		this.mid = mid; 
		this.orderid = orderid;
		this.custid = custid;
		this.industrytypeid = industrytypeid;
		this.channelid = channelid;
		this.txnamount = txnamount;
		this.website = website;
		this.callbackurl = callbackurl;
		this.email = email;
		this.mobileno = mobileno;
	}


	public String getMid() {
		return mid;
	}


	public void setMid(String mid) {
		this.mid = mid;
	}


	public String getOrderid() {
		return orderid;
	}


	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}


	public String getCustid() {
		return custid;
	}


	public void setCustid(String custid) {
		this.custid = custid;
	}


	public String getIndustrytypeid() {
		return industrytypeid;
	}


	public void setIndustrytypeid(String industrytypeid) {
		this.industrytypeid = industrytypeid;
	}


	public String getChannelid() {
		return channelid;
	}


	public void setChannelid(String channelid) {
		this.channelid = channelid;
	}


	public String getTxnamount() {
		return txnamount;
	}


	public void setTxnamount(String txnamount) {
		this.txnamount = txnamount;
	}


	public String getWebsite() {
		return website;
	}


	public void setWebsite(String website) {
		this.website = website;
	}


	public String getCallbackurl() {
		return callbackurl;
	}


	public void setCallbackurl(String callbackurl) {
		this.callbackurl = callbackurl;
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
	
}
