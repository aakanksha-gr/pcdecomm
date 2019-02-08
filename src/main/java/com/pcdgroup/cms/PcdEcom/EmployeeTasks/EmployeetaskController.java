package com.pcdgroup.cms.PcdEcom.EmployeeTasks;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeetaskController {

	@Autowired
	EmployeetaskServiceImpl employeetaskServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/createEmployeetask")
	public String Createemployeetask(@RequestBody Employeetaskmaster employeetaskmaster) {
	
		return employeetaskServiceImpl.createEmployeetask(employeetaskmaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmployeetaskByEmptaskid/{emptaskid}")
	public Employeetaskmaster getEmployeetaskByEmptaskid(@PathVariable Integer emptaskid) {
		
		return employeetaskServiceImpl.getEmployeetask(emptaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmployeetaskByEmpid/{empid}/{index}")
	public List<Employeetaskmaster> getEmployeetaskByEmpid(@PathVariable Integer empid, @PathVariable Integer index) {
		
		return employeetaskServiceImpl.getEmployeetaskByEmpid(empid, index);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getTaskdetailsByEmpid/{empid}/{index}")
	public List<?> getTaskdetailsByEmpid(@PathVariable Integer empid, @PathVariable Integer index) {
		
		return employeetaskServiceImpl.getTaskdetailsByEmpid(empid, index);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllEmployeetask/{index}")
	public List<?> getAllEmployeetask(@PathVariable Integer index) {
		
		return employeetaskServiceImpl.getAllEmployeeTasks(index);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateEmployeetask/{emptaskid}")
	public String updateEmployeetask(@RequestBody Employeetaskmaster employeetaskmaster, @PathVariable Integer emptaskid) {
		
		return employeetaskServiceImpl.updateEmployeetask(employeetaskmaster, emptaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteTask/{emptaskid}")
	public String deleteEmployeetask(@PathVariable Integer emptaskid) {
		
		return employeetaskServiceImpl.deleteEmployeetask(emptaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllEmployeePendingtask")
	public List<?> getAllEmployeePendingtask() {
		
		return employeetaskServiceImpl.getAllEmployeePendingtasks();
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllEmployeePendingtaskByDeadline")
	public List<?> getAllEmployeePendingtaskByDeadline() {
		
		return employeetaskServiceImpl.getAllEmployeePendingtasksByDeadline();
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllEmployeecompletedtask")
	public List<?> getAllEmployeecompletedtask() {
		
		return employeetaskServiceImpl.getAllEmployeeCompletedtasks();
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmployeependingtaskByEmpid/{empid}")
	public List<?> getEmployeependingtaskByEmpid(@PathVariable Integer empid) {
		
		return employeetaskServiceImpl.getAllEmployeependingtaskByEmpid(empid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmployeecompletedtaskByEmpid/{empid}")
	public List<?> getEmployeecompletedByEmpid(@PathVariable Integer empid) {
		
		return employeetaskServiceImpl.getEmployeecompletedByEmpid(empid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllEmployeependingtaskCrossedDeadlineByEmpid/{empid}")
	public List<?> getEmployeependingtaskCrossedDeadlineByEmpid(@PathVariable Integer empid) {
		
		return employeetaskServiceImpl.getAllEmployeependingtaskCrossedDeadlineByEmpid(empid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/countTotalNoOfPendingTasksByEmpid/{empid}")
	public Integer countTotalNoOfPendingTasksByEmpid(@PathVariable Integer empid) {
		
		return employeetaskServiceImpl.countTotalNoOfPendingTasksByEmpid(empid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/countTotalNoOfCompletedTasksEmpid/{empid}")
	public Integer countTotalNoOfCompletedTasksEmpid(@PathVariable Integer empid) {
		
		return employeetaskServiceImpl.countTotalNoOfCompletedTasksEmpid(empid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/countTotalNoOfPendingTasks")
	public Integer countTotalNoOfPendingTasks() {
		
		return employeetaskServiceImpl.countTotalNoOfPendingTasks();
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/countTotalNoOfCompletedTasks")
	public Integer countTotalNoOfCompletedTasks() {
		
		return employeetaskServiceImpl.countTotalNoOfCompletedTasks();
		
	}
	
}
