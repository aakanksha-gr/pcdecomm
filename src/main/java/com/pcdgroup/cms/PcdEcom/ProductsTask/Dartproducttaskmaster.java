package com.pcdgroup.cms.PcdEcom.ProductsTask;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="dartproducttaskmaster")
public class Dartproducttaskmaster {

	@Id
	@Column(name="dartproducttaskid")
	private Integer dartproducttaskid; 
	
	@Column(name="dartpid")
	private Integer dartpid; 
	
	@Column(name="dartptid")
	private Integer dartptid;

	
	public Dartproducttaskmaster() {
		super();
	}

	public Dartproducttaskmaster(Integer dartproducttaskid, Integer dartpid, Integer dartptid) {
		super();
		this.dartproducttaskid = dartproducttaskid;
		this.dartpid = dartpid;
		this.dartptid = dartptid;
	}

	public Integer getDartproducttaskid() {
		return dartproducttaskid;
	}

	public void setDartproducttaskid(Integer dartproducttaskid) {
		this.dartproducttaskid = dartproducttaskid;
	}

	public Integer getDartpid() {
		return dartpid;
	}

	public void setDartpid(Integer dartpid) {
		this.dartpid = dartpid;
	}

	public Integer getDartptid() {
		return dartptid;
	}

	public void setDartptid(Integer dartptid) {
		this.dartptid = dartptid;
	}
	
}
