package com.pcdgroup.cms.PcdEcom.EmployeeTasks;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="employeetaskmaster")
public class Employeetaskmaster {

	@Id
	@Column(name="employeetaskid")
	private Integer employeetaskid; 
	
	@Column(name="employeetaskempid")
	private Integer employeetaskempid;
	
	@Column(name="taskidemployeetask")
	private Integer taskidemployeetask;
	
	@Column(name="taskdatetime") 
	private Date taskdatetime;
	
	@Column(name="taskdeadline")
	private Date taskdeadline;
	
	@Column(name="taskstatus")
	private String taskstatus;
	
	public Employeetaskmaster() {
		super();
	}

	public Employeetaskmaster(Integer employeetaskid, Integer employeetaskempid, Integer taskidemployeetask, Date taskdatetime, Date taskdeadline, String taskstatus) {
		super();
		this.employeetaskid = employeetaskid;
		this.employeetaskempid = employeetaskempid;
		this.taskidemployeetask = taskidemployeetask;
		this.taskdatetime = taskdatetime;
		this.taskdeadline = taskdeadline;
		this.taskstatus = taskstatus;
	}

	public Integer getEmployeetaskid() {
		return employeetaskid;
	}

	public void setEmployeetaskid(Integer employeetaskid) {
		this.employeetaskid = employeetaskid;
	}

	public Integer getEmployeetaskempid() {
		return employeetaskempid;
	}

	public void setEmployeetaskempid(Integer employeetaskempid) {
		this.employeetaskempid = employeetaskempid;
	}

	public Integer getTaskidemployeetask() {
		return taskidemployeetask;
	}

	public void setTaskidemployeetask(Integer taskidemployeetask) {
		this.taskidemployeetask = taskidemployeetask;
	}

	public Date getTaskdatetime() {
		return taskdatetime;
	}

	public void setTaskdatetime(Date taskdatetime) {
		this.taskdatetime = taskdatetime;
	}

	public Date getTaskdeadline() {
		return taskdeadline;
	}

	public void setTaskdeadline(Date taskdeadline) {
		this.taskdeadline = taskdeadline;
	}

	public String getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}
	
}
