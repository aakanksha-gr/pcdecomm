package com.pcdgroup.cms.PcdEcom.EmployeeIncentive;

import java.util.HashMap;
import java.util.List;

public interface EmployeeincentiveService {
	
	public String addEmployeeIncentive(EmployeeIncentivemaster employeeIncentivemaster, Integer empid);
	public List<?> getAllEmployeeIncentive(Integer index);
	public EmployeeIncentivemaster getEmployeeIncentiveById(Integer empid);
	public HashMap<?,?> getEmployeeIncentiveByMonth(EmployeeIncentiveBean employeeIncentiveBean);
	public HashMap<?,?> getAllEmployeeIncentiveByMonth(EmployeeIncentiveBean employeeIncentiveBean);
	public HashMap<?,?> getEmployeeIncentiveByYear(EmployeeIncentiveBean employeeIncentiveBean);
	public HashMap<?,?> getAllEmployeeIncentiveByYear(EmployeeIncentiveBean employeeIncentiveBean);
	public HashMap<?, ?> getAllEmployeeIncentiveByMonthYear(EmployeeIncentiveBean employeeIncentiveBean);
	
}
