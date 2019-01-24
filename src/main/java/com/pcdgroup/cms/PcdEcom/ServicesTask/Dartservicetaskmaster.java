package com.pcdgroup.cms.PcdEcom.ServicesTask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dartservicetaskmaster")
public class Dartservicetaskmaster {

	@Id
	@Column(name="dartservicetaskid")
	private Integer dartservicetaskid; 
	
	@Column(name="dartsid")
	private Integer dartsid; 
	
	@Column(name="dartstid")
	private Integer dartstid;

	
	public Dartservicetaskmaster() {
		super();
	}

	public Dartservicetaskmaster(Integer dartservicetaskid, Integer dartsid, Integer dartstid) {
		super();
		this.dartservicetaskid = dartservicetaskid;
		this.dartsid = dartsid;
		this.dartstid = dartstid;
	}

	public Integer getDartservicetaskid() {
		return dartservicetaskid;
	}

	public void setDartservicetaskid(Integer dartservicetaskid) {
		this.dartservicetaskid = dartservicetaskid;
	}

	public Integer getDartsid() {
		return dartsid;
	}

	public void setDartsid(Integer dartsid) {
		this.dartsid = dartsid;
	}

	public Integer getDartstid() {
		return dartstid;
	}

	public void setDartstid(Integer dartstid) {
		this.dartstid = dartstid;
	}
	
}
