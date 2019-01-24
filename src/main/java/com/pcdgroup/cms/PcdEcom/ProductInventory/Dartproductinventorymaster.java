package com.pcdgroup.cms.PcdEcom.ProductInventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dartproductinventorymaster")
public class Dartproductinventorymaster {

	@Id
	@Column(name="dartproductinventoryid")
	private Integer dartproductinventoryid; 
	
	@Column(name="dartproductinventorypid")
	private Integer dartproductinventorypid; 
	
	@Column(name="dartproductinventorytid")
	private Integer dartproductinventorytid;
	
	
	public Dartproductinventorymaster() {
		super();
	}

	public Dartproductinventorymaster(Integer dartproductinventoryid, Integer dartproductinventorypid,
			Integer dartproductinventorytid) {
		super();
		this.dartproductinventoryid = dartproductinventoryid;
		this.dartproductinventorypid = dartproductinventorypid;
		this.dartproductinventorytid = dartproductinventorytid;
	}

	public Integer getDartproductinventoryid() {
		return dartproductinventoryid;
	}

	public void setDartproductinventoryid(Integer dartproductinventoryid) {
		this.dartproductinventoryid = dartproductinventoryid;
	}

	public Integer getDartproductinventorypid() {
		return dartproductinventorypid;
	}

	public void setDartproductinventorypid(Integer dartproductinventorypid) {
		this.dartproductinventorypid = dartproductinventorypid;
	}

	public Integer getDartproductinventorytid() {
		return dartproductinventorytid;
	}

	public void setDartproductinventorytid(Integer dartproductinventorytid) {
		this.dartproductinventorytid = dartproductinventorytid;
	}
	
}
