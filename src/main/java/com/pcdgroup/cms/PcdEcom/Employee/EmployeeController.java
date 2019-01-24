package com.pcdgroup.cms.PcdEcom.Employee;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.pcdgroup.cms.PcdEcom.Employeelogin.Employeeloginmaster;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/employeeLogin")
	public String employeeLogin(@RequestBody Employeemaster employeemaster, Employeeloginmaster employeeloginmaster) {
	
		return employeeServiceImpl.employeeLogin(employeemaster, employeeloginmaster);
	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/createEmployee")
	public String createEmployee(@RequestBody Employeemaster employeemaster) {
	
		return employeeServiceImpl.createEmployee(employeemaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmployee/{employeeid}")
	public Employeemaster getEmployee(@PathVariable Integer employeeid) {
		
		return employeeServiceImpl.getEmployee(employeeid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmployeeByBrand/{brand}")
	public List<?> getEmployeeByBrand(@PathVariable String brand) {
		
		return employeeServiceImpl.getEmployeeByBrand(brand);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmployeeByWorkingarea/{employeeworkingbrand}/{employeeworkingtype}/{index}")
	public List<?> getEmployeeByWorkingarea(@PathVariable String employeeworkingbrand, @PathVariable String employeeworkingtype, @PathVariable Integer index) {
		
		return employeeServiceImpl.getEmployeeByWorkingArea(employeeworkingbrand, employeeworkingtype, index);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllEmployees")
	public List<?> getAllEmployees() {
		
		return employeeServiceImpl.getAllEmploiees();
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateEmployee/{employeeid}")
	public String updateEmployee(@RequestBody Employeemaster employeemaster, @PathVariable Integer employeeid) {
		
		return employeeServiceImpl.updateEmployee(employeemaster, employeeid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteEmployee/{employeeid}")
	public String deleteEmployee(@PathVariable Integer employeeid) {
		
		return employeeServiceImpl.deleteEmployee(employeeid);
		
	}
	
}
