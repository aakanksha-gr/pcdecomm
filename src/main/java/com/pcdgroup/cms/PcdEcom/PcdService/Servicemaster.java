package com.pcdgroup.cms.PcdEcom.PcdService;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pcdservicemaster")
public class Servicemaster {

	@Id
	@Column(name="pcdserviceid")
	private Integer serviceid;
	
	@Column(name="pcdservicename")
	private String servicename;
	
	@Column(name="pcdserviceperunit")
	private String serviceperunit;
	
	@Column(name="pcdserviceduration")
	private String duration;
	
	@Column(name="pcdserviceprice")
	private String price;
		
	@Column(name="pcdservicehsncode")
	private String hsncode;
	
	@Column(name="pcdservicegst")
	private String gst;
	
	@Column(name="pcdservicestatus")
	private String servicestatus;

	@Column(name="pcdserviceimage")
	private String pcdserviceimage;
	
	public Servicemaster() {
		
	}
	
	public Servicemaster(Integer serviceid, String servicename, String serviceperunit, String duration, String price,
			String hsncode, String gst, String servicestatus, String pcdserviceimage) {
		
		super();
		
		this.serviceid = serviceid;
		this.servicename = servicename;
		this.serviceperunit = serviceperunit;
		this.duration = duration;
		this.price = price;
		this.hsncode = hsncode;
		this.gst = gst;
		this.servicestatus = servicestatus;
		this.pcdserviceimage = pcdserviceimage;
	
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

	public String getPmimistock() {
		return servicestatus;
	}

	public void setPmimistock(String servicestatus) {
		this.servicestatus = servicestatus;
	}

	public String getServicestatus() {
		return servicestatus;
	}

	public void setServicestatus(String servicestatus) {
		this.servicestatus = servicestatus;
	}

	public String getPcdserviceimage() {
		return pcdserviceimage;
	}

	public void setPcdserviceimage(String pcdserviceimage) {
		this.pcdserviceimage = pcdserviceimage;
	}
	
}
