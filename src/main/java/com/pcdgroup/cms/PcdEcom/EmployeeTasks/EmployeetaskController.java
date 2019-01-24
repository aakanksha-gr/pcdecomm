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
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmployeetaskByEmpid/{empid}")
	public List<Employeetaskmaster> getEmployeetaskByEmpid(@PathVariable Integer empid) {
		
		return employeetaskServiceImpl.getEmployeetaskByEmpid(empid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllEmployeetask")
	public List<?> getAllEmployeetask() {
		
		return employeetaskServiceImpl.getAllEmployeeTasks();
		
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
	
}
