package com.pcdgroup.cms.PcdEcom.Employeelogin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeloginController {

	@Autowired
	EmployeeloginServiceImpl employeeloginServiceImpl;
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllLoginDetails/{index}")
	public List<?> getAllLoginDetails(@PathVariable Integer index) {
		return employeeloginServiceImpl.getAllEmployeeLoginDetails(index);
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getEmployeeLoginDetailsByEmpId/{empid}/{index}")
	public List<?> getEmployeeLoginDetailsByEmpId(@PathVariable Integer empid, @PathVariable Integer index) {
		return employeeloginServiceImpl.getEmployeeLoginDetailsByEmpId(empid, index);
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addLoginDetailsByEmpid")
	public String addLoginDetailsByEmpid(@RequestBody Employeeloginmaster employeeloginmaster) {
		return employeeloginServiceImpl.addLoginDetailsByEmpid(employeeloginmaster);
	}
	
}
