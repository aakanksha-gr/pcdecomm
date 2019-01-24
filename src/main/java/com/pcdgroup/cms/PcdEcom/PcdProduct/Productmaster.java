package com.pcdgroup.cms.PcdEcom.PcdProduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pcdproductmaster")
public class Productmaster {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="productid")
	private Integer pid;
	
	@Column(name="productname")
	private String pname;
	
	@Column(name="productimage")
	private String pimage;
	
	@Column(name="producttype")
	private String ptype;
	
	@Column(name="productprice")
	private String price;
	
	@Column(name="productminimumstock")
	private String pmimistock;
	
	@Column(name="productstock")
	private String stock;
	
	@Column(name="hsncode")
	private String hsncode;
	
	@Column(name="gst")
	private String gst;
	
	@Column(name="pcdproductstockstatus")
	private String pcdproductstockstatus;
	
	public Productmaster() {
		
	}

	public Productmaster(Integer pid, String pname, String pimage, String ptype, String price, String pmimistock,
			String stock, String hsncode, String gst, String pcdproductstockstatus) {
		
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
		this.pcdproductstockstatus = pcdproductstockstatus;
		
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

	public String getPcdproductstockstatus() {
		return pcdproductstockstatus;
	}

	public void setPcdproductstockstatus(String pcdproductstockstatus) {
		this.pcdproductstockstatus = pcdproductstockstatus;
	}
	
}
