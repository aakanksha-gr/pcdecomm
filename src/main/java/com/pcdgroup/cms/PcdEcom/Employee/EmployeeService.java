package com.pcdgroup.cms.PcdEcom.Employee;

import java.util.List;

import com.pcdgroup.cms.PcdEcom.Employeelogin.Employeeloginmaster;

public interface EmployeeService {

	public Employeemaster employeeLogin(Employeemaster employeemaster, Employeeloginmaster employeeloginmaster);
	public String createEmployee(Employeemaster employeemaster);
	public Employeemaster getEmployee(Integer employeeid);
	public List<Employeemaster> getAllEmploiees();
	public String deleteEmployee(Integer employeeid);
	public String updateEmployee(Employeemaster employeemaster, Integer employeeid);
	public List<?> getEmployeeByWorkingArea(String employeeworkingbrand, String employeeworkingtype, Integer index);
	public List<?> getEmployeeByBrand(String brand);
	public Integer countPcdBrandEmployee();
	public Integer countDartBrandEmployee();
	
}
