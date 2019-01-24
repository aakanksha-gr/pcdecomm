package com.pcdgroup.cms.PcdEcom.ServicesTask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pcdservicetaskmaster")
public class Pcdservicetaskmaster {

	@Id
	@Column(name="pcdservicetaskid")
	private Integer pcdservicetaskid; 
	
	@Column(name="pcdsid")
	private Integer pcdsid; 
	
	@Column(name="pstaskid")
	private Integer pstaskid;
	

	public Pcdservicetaskmaster() {
		super();
	}

	public Pcdservicetaskmaster(Integer pcdservicetaskid, Integer pcdsid, Integer pstaskid) {
		super();
		this.pcdservicetaskid = pcdservicetaskid;
		this.pcdsid = pcdsid;
		this.pstaskid = pstaskid;
	}

	public Integer getPcdservicetaskid() {
		return pcdservicetaskid;
	}

	public void setPcdservicetaskid(Integer pcdservicetaskid) {
		this.pcdservicetaskid = pcdservicetaskid;
	}

	public Integer getPcdsid() {
		return pcdsid;
	}

	public void setPcdsid(Integer pcdsid) {
		this.pcdsid = pcdsid;
	}

	public Integer getPstaskid() {
		return pstaskid;
	}

	public void setPstaskid(Integer pstaskid) {
		this.pstaskid = pstaskid;
	}
	
}
