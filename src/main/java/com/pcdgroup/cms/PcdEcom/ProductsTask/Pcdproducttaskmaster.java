package com.pcdgroup.cms.PcdEcom.ProductsTask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pcdproducttaskmaster")
public class Pcdproducttaskmaster {

	@Id
	@Column(name="pcdproducttaskid")
	private Integer pcdproducttaskid; 
	
	@Column(name="pcdpid")
	private Integer pcdpid; 
	
	@Column(name="tid")
	private Integer tid;

	
	public Pcdproducttaskmaster() {
		super();
	}

	public Pcdproducttaskmaster(Integer pcdproducttaskid, Integer pcdpid, Integer tid) {
		super();
		this.pcdproducttaskid = pcdproducttaskid;
		this.pcdpid = pcdpid;
		this.tid = tid;
	}

	public Integer getPcdproducttaskid() {
		return pcdproducttaskid;
	}

	public void setPcdproducttaskid(Integer pcdproducttaskid) {
		this.pcdproducttaskid = pcdproducttaskid;
	}

	public Integer getPcdpid() {
		return pcdpid;
	}

	public void setPcdpid(Integer pcdpid) {
		this.pcdpid = pcdpid;
	}

	public Integer getTid() {
		return tid;
	}

	public void setTid(Integer tid) {
		this.tid = tid;
	}
	
}
