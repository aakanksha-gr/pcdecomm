package com.pcdgroup.cms.PcdEcom.EmployeeIncentive;

import java.util.HashMap;
import java.util.List;

public interface EmployeeincentiveService {
	
	public String addEmployeeIncentive(EmployeeIncentivemaster employeeIncentivemaster, Integer empid);
	public List<?> getAllEmployeeIncentive(Integer index);
	public EmployeeIncentivemaster getEmployeeIncentiveById(Integer empid);
	public HashMap<?,?> getEmployeeIncentiveByMonth(EmployeeIncentiveBean employeeIncentiveBean);
	//public List<EmployeeIncentivemaster> getAllEmployeeIncentiveByMonth(EmployeeIncentivemaster employeeIncentivemaster);
	/*public List<EmployeeIncentivemaster> getEmployeeIncentiveByYear(EmployeeIncentivemaster employeeIncentivemaster);
	public List<EmployeeIncentivemaster> getAllEmployeeIncentiveByYear(EmployeeIncentivemaster employeeIncentivemaster);*/
	
}
