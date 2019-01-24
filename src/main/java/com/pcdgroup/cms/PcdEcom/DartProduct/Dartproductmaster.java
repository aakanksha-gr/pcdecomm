package com.pcdgroup.cms.PcdEcom.DartProduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dartproductmaster")
public class Dartproductmaster {

	@Id
	@Column(name="dartproductid")
	private Integer pid;
	
	@Column(name="dartproductname")
	private String pname;
	
	@Column(name="dartproductimage")
	private String pimage;
	
	@Column(name="dartproducttype")
	private String ptype;
	
	@Column(name="dartproductprice")
	private String price;
	
	@Column(name="dartproductminimumstock")
	private String pmimistock;
	
	@Column(name="dartproductstock")
	private String stock;
	
	@Column(name="darthsncode")
	private String hsncode;
	
	@Column(name="dartgst")
	private String gst;
	
	@Column(name="dartproductstockstatus")
	private String dartproductstockstatus;
	
	public Dartproductmaster() {
		
	}

	public Dartproductmaster(Integer pid, String pname, String pimage, String ptype, String price, String pmimistock,
			String stock, String hsncode, String gst, String dartproductstockstatus) {
		
		super();
		
		this.pid = pid;
		this.pname = pname;
		this.pimage = pimage;
		this.ptype = ptype;
		this.price = price;
		this.pmimistock = pmimistock;
		this.stock = stock;
		this.hsncode = hsncode;
		this.gst = gst;
		this.dartproductstockstatus = dartproductstockstatus;
	
	}

	public Integer getPid() {
		return pid;
	}

	public void setPid(Integer pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getPimage() {
		return pimage;
	}

	public void setPimage(String pimage) {
		this.pimage = pimage;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getPmimistock() {
		return pmimistock;
	}

	public void setPmimistock(String pmimistock) {
		this.pmimistock = pmimistock;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
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

	public String getDartproductstockstatus() {
		return dartproductstockstatus;
	}

	public void setDartproductstockstatus(String dartproductstockstatus) {
		this.dartproductstockstatus = dartproductstockstatus;
	}
	
}
