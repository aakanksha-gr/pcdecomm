package com.pcdgroup.cms.PcdEcom.EmployeeTasks;

import java.util.List;

public interface EmployeetaskService {

	public String createEmployeetask(Employeetaskmaster employeetaskmaster);
	public Employeetaskmaster getEmployeetask(Integer emptaskid);
	public List<Employeetaskmaster> getAllEmployeeTasks();
	public String deleteEmployeetask(Integer emptaskid);
	public String updateEmployeetask(Employeetaskmaster employeetaskmaster, Integer emptaskid);
	public List<Employeetaskmaster> getAllEmployeePendingtasks();
	public List<Employeetaskmaster> getAllEmployeePendingtasksByDeadline();
	public List<Employeetaskmaster> getEmployeetaskByEmpid(Integer empid);
	
}
