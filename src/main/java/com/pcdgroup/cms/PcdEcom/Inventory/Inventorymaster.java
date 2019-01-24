package com.pcdgroup.cms.PcdEcom.Inventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inventorymaster")
public class Inventorymaster {

	@Id
	@Column(name="inventoryid")
	private Integer inventoryid; 
	
	@Column(name="inventoryname")
	private String inventoryname;
	
	@Column(name="inventorybrand")
	private String inventorybrand;
	
	@Column(name="inventorylocation")
	private String inventorylocation;
	
	@Column(name="inventoryquantity")
	private String inventoryquantity;
	
	@Column(name="inventorymimimumstock")
	private String inventorymimimumstock;
	
	@Column(name="inventorystockstatus")
	private String inventorystockstatus;
	
	@Column(name="inventoryhsncode")
	private String inventoryhsncode;
	
	@Column(name="inventorygst")
	private String inventorygst;
	
	@Column(name="inventorystock")
	private String inventorystock;

	public Inventorymaster() {
		super();
	}

	public Inventorymaster(Integer inventoryid, String inventoryname, String inventorybrand, String inventorylocation,
			String inventoryquantity, String inventorymimimumstock, String inventorystockstatus,
			String inventoryhsncode, String inventorygst, String inventorystock) {
		super();
		this.inventoryid = inventoryid;
		this.inventoryname = inventoryname;
		this.inventorybrand = inventorybrand;
		this.inventorylocation = inventorylocation;
		this.inventoryquantity = inventoryquantity;
		this.inventorymimimumstock = inventorymimimumstock;
		this.inventorystockstatus = inventorystockstatus;
		this.inventoryhsncode = inventoryhsncode;
		this.inventorygst = inventorygst;
		this.inventorystock = inventorystock;
	}

	public Integer getInventoryid() {
		return inventoryid;
	}

	public void setInventoryid(Integer inventoryid) {
		this.inventoryid = inventoryid;
	}

	public String getInventoryname() {
		return inventoryname;
	}

	public void setInventoryname(String inventoryname) {
		this.inventoryname = inventoryname;
	}

	public String getInventorybrand() {
		return inventorybrand;
	}

	public void setInventorybrand(String inventorybrand) {
		this.inventorybrand = inventorybrand;
	}

	public String getInventorylocation() {
		return inventorylocation;
	}

	public void setInventorylocation(String inventorylocation) {
		this.inventorylocation = inventorylocation;
	}

	public String getInventoryquantity() {
		return inventoryquantity;
	}

	public void setInventoryquantity(String inventoryquantity) {
		this.inventoryquantity = inventoryquantity;
	}

	public String getInventorymimimumstock() {
		return inventorymimimumstock;
	}

	public void setInventorymimimumstock(String inventorymimimumstock) {
		this.inventorymimimumstock = inventorymimimumstock;
	}

	public String getInventorystockstatus() {
		return inventorystockstatus;
	}

	public void setInventorystockstatus(String inventorystockstatus) {
		this.inventorystockstatus = inventorystockstatus;
	}

	public String getInventoryhsncode() {
		return inventoryhsncode;
	}

	public void setInventoryhsncode(String inventoryhsncode) {
		this.inventoryhsncode = inventoryhsncode;
	}

	public String getInventorygst() {
		return inventorygst;
	}

	public void setInventorygst(String inventorygst) {
		this.inventorygst = inventorygst;
	}

	public String getInventorystock() {
		return inventorystock;
	}

	public void setInventorystock(String inventorystock) {
		this.inventorystock = inventorystock;
	}
	
}
