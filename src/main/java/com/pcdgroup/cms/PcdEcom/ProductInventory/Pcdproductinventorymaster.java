package com.pcdgroup.cms.PcdEcom.ProductInventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pcdproductinventorymaster")
public class Pcdproductinventorymaster {

	@Id
	@Column(name="pcdproductinventoryid") 
	private Integer pcdproductinventoryid;
	
	@Column(name="pcdproductinventorypid")
	private Integer pcdproductinventorypid;
	
	@Column(name="pcdproductinventorytid")
	private Integer pcdproductinventorytid;

	
	public Pcdproductinventorymaster() {
		super();
	}

	public Pcdproductinventorymaster(Integer pcdproductinventoryid, Integer pcdproductinventorypid,
			Integer pcdproductinventorytid) {
		super();
		this.pcdproductinventoryid = pcdproductinventoryid;
		this.pcdproductinventorypid = pcdproductinventorypid;
		this.pcdproductinventorytid = pcdproductinventorytid;
	}

	public Integer getPcdproductinventoryid() {
		return pcdproductinventoryid;
	}

	public void setPcdproductinventoryid(Integer pcdproductinventoryid) {
		this.pcdproductinventoryid = pcdproductinventoryid;
	}

	public Integer getPcdproductinventorypid() {
		return pcdproductinventorypid;
	}

	public void setPcdproductinventorypid(Integer pcdproductinventorypid) {
		this.pcdproductinventorypid = pcdproductinventorypid;
	}

	public Integer getPcdproductinventorytid() {
		return pcdproductinventorytid;
	}

	public void setPcdproductinventorytid(Integer pcdproductinventorytid) {
		this.pcdproductinventorytid = pcdproductinventorytid;
	}
	
}
