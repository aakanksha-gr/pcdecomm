package com.pcdgroup.cms.PcdEcom.EmployeeTasks;

import java.util.List;

public interface EmployeetaskService {

	public String createEmployeetask(Employeetaskmaster employeetaskmaster);
	public Employeetaskmaster getEmployeetask(Integer emptaskid);
	public List<Employeetaskmaster> getAllEmployeeTasks(Integer index);
	public String deleteEmployeetask(Integer emptaskid);
	public String updateEmployeetask(Employeetaskmaster employeetaskmaster, Integer emptaskid);
	public List<Employeetaskmaster> getAllEmployeePendingtasks();
	public List<Employeetaskmaster> getAllEmployeePendingtasksByDeadline();
	public List<Employeetaskmaster> getEmployeetaskByEmpid(Integer empid, Integer index);
	public List<?> getAllEmployeependingtaskByEmpid(Integer empid);
	public List<?> getAllEmployeependingtaskCrossedDeadlineByEmpid(Integer empid);
	public Integer countTotalNoOfPendingTasksByEmpid(Integer empid);
	public Integer countTotalNoOfCompletedTasksEmpid(Integer empid);
	public Integer countTotalNoOfPendingTasks();
	public Integer countTotalNoOfCompletedTasks();
	public List<?> getEmployeecompletedByEmpid(Integer empid);
	public List<?> getAllEmployeeCompletedtasks();
	public List<?> getTaskdetailsByEmpid(Integer empid, Integer index);
	
}
