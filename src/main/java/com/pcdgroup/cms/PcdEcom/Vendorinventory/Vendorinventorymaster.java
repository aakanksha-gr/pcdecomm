package com.pcdgroup.cms.PcdEcom.Vendorinventory;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="vendorinventorymaster")
public class Vendorinventorymaster {

	@Id
	@Column(name="vendorinventoryid") 
	private Integer vendorinventoryid; 
	
	@Column(name="vid")
	private Integer vid; 
	
	@Column(name="invid")
	private Integer invid;
	
	
	public Vendorinventorymaster() {
		super();
	}

	public Vendorinventorymaster(Integer vendorinventoryid, Integer vid, Integer invid) {
		super();
		this.vendorinventoryid = vendorinventoryid;
		this.vid = vid;
		this.invid = invid;
	}

	public Integer getVendorinventoryid() {
		return vendorinventoryid;
	}

	public void setVendorinventoryid(Integer vendorinventoryid) {
		this.vendorinventoryid = vendorinventoryid;
	}

	public Integer getVid() {
		return vid;
	}

	public void setVid(Integer vid) {
		this.vid = vid;
	}

	public Integer getInvid() {
		return invid;
	}

	public void setInvid(Integer invid) {
		this.invid = invid;
	}
	
}
