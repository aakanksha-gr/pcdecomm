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
	/* ----------------------------------------------URL not mention in excel sheet------------------------------------------------------------------ */
	@RequestMapping(method=RequestMethod.POST, value="/getAllEmployeeincentiveByMonth")
	public HashMap<?,?> getAllEmployeeincentiveMonth(@RequestBody EmployeeIncentiveBean incentiveBean) {
		
		return employeeincentiveServiceImpl.getAllEmployeeIncentiveByMonth(incentiveBean);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getEmployeeincentiveByYear")
	public HashMap<?,?> getEmployeeincentiveByYear(@RequestBody EmployeeIncentiveBean incentiveBean) {
		
		return employeeincentiveServiceImpl.getEmployeeIncentiveByYear(incentiveBean);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getAllEmployeeincentiveByYear")
	public HashMap<?,?> getAllEmployeeincentiveYear(@RequestBody EmployeeIncentiveBean incentiveBean) {
		
		return employeeincentiveServiceImpl.getAllEmployeeIncentiveByYear(incentiveBean);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getAllEmployeeincentiveByMonthYear")
	public HashMap<?,?> getAllEmployeeincentiveMonthYear(@RequestBody EmployeeIncentiveBean incentiveBean) {
		
		return employeeincentiveServiceImpl.getAllEmployeeIncentiveByMonthYear(incentiveBean);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getEmployeeincentiveByMonthYear")
	public HashMap<?,?> getEmployeeincentiveMonthYear(@RequestBody EmployeeIncentiveBean incentiveBean) {
		
		return employeeincentiveServiceImpl.getEmployeeIncentiveByMonthYear(incentiveBean);
		
	}
	
}
