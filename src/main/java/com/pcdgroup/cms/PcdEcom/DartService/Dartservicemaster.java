package com.pcdgroup.cms.PcdEcom.DartService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dartservicemaster")
public class Dartservicemaster {

	@Id
	@Column(name="dartserviceid")
	private Integer serviceid;
	
	@Column(name="dartservicename")
	private String servicename;
	
	@Column(name="dartserviceperunit")
	private String serviceperunit;
	
	@Column(name="dartserviceduration")
	private String duration;
	
	@Column(name="dartserviceprice")
	private String price;
		
	@Column(name="dartservicehsncode")
	private String hsncode;
	
	@Column(name="dartservicegst")
	private String gst;
	
	@Column(name="dartservicestatus")
	private String servicestatus;
	
	@Column(name="dartserviceimage")
	private String dartserviceimage;
	
	public Dartservicemaster() {
		
	}

	public Dartservicemaster(Integer serviceid, String servicename, String serviceperunit, String duration,
			String price, String hsncode, String gst, String servicestatus, String dartserviceimage) {
		
		super();
		
		this.serviceid = serviceid;
		this.servicename = servicename;
		this.serviceperunit = serviceperunit;
		this.duration = duration;
		this.price = price;
		this.hsncode = hsncode;
		this.gst = gst;
		this.servicestatus = servicestatus;
		this.dartserviceimage = dartserviceimage;
	
	}

	public Integer getServiceid() {
		return serviceid;
	}

	public void setServiceid(Integer serviceid) {
		this.serviceid = serviceid;
	}

	public String getServicename() {
		return servicename;
	}

	public void setServicename(String servicename) {
		this.servicename = servicename;
	}

	public String getServiceperunit() {
		return serviceperunit;
	}

	public void setServiceperunit(String serviceperunit) {
		this.serviceperunit = serviceperunit;
	}

	public String getDuration() {
		return duration;
	}

	public void setDuration(String duration) {
		this.duration = duration;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getHsncode() {
		return hsncode;
	}

	public void setHsncode(String hsncode) {
		this.hsncode = hsncode;
	}

	public String getGst() {
		return gst;
	}

	public void setGst(String gst) {
		this.gst = gst;
	}

	public String getServicestatus() {
		return servicestatus;
	}

	public void setServicestatus(String servicestatus) {
		this.servicestatus = servicestatus;
	}

	public String getDartserviceimage() {
		return dartserviceimage;
	}

	public void setDartserviceimage(String dartserviceimage) {
		this.dartserviceimage = dartserviceimage;
	}
	
}
