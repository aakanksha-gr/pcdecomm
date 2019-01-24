package com.pcdgroup.cms.PcdEcom.EmployeeIncentive;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeincentiveController {

	@Autowired
	EmployeeincentiveServiceImpl employeeincentiveServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/AddEmployeeincentive/{empid}")
	public String addIncentive(@RequestBody EmployeeIncentivemaster employeeIncentivemaster, @PathVariable Integer empid) {
		
		return employeeincentiveServiceImpl.addEmployeeIncentive(employeeIncentivemaster, empid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllEmployeeincentive/{index}")
	public List<?> getAllEmployeeincentive(@PathVariable Integer index) {
		
		return employeeincentiveServiceImpl.getAllEmployeeIncentive(index);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmployeeincentive/{empid}")
	public EmployeeIncentivemaster getEmployeeincentiveById(@PathVariable Integer empid) {
		
		return employeeincentiveServiceImpl.getEmployeeIncentiveById(empid);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getEmployeeincentiveByMonth")
	public HashMap<?,?> getEmployeeincentiveByMonth(@RequestBody EmployeeIncentiveBean employeeIncentiveBean) {
		
		return employeeincentiveServiceImpl.getEmployeeIncentiveByMonth(employeeIncentiveBean);
		
	}
	
	/*@RequestMapping(method=RequestMethod.POST, value="/getAllEmployeeincentiveByMonth")
	public List<EmployeeIncentivemaster> getAllEmployeeincentiveMonth(@RequestBody EmployeeIncentivemaster employeeIncentivemaster) {
		
		return employeeincentiveServiceImpl.getAllEmployeeIncentiveByMonth(employeeIncentivemaster);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getEmployeeincentiveByYear")
	public List<EmployeeIncentivemaster> getEmployeeincentiveByYear(@RequestBody EmployeeIncentivemaster employeeIncentivemaster) {
		
		return employeeincentiveServiceImpl.getEmployeeIncentiveByYear(employeeIncentivemaster);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getAllEmployeeincentiveByYear")
	public List<EmployeeIncentivemaster> getAllEmployeeincentiveYear(@RequestBody EmployeeIncentivemaster employeeIncentivemaster) {
		
		return employeeincentiveServiceImpl.getAllEmployeeIncentiveByYear(employeeIncentivemaster);
		
	}*/
	
}
