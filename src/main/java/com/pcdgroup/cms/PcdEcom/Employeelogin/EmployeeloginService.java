package com.pcdgroup.cms.PcdEcom.Employeelogin;

import java.util.List;

public interface EmployeeloginService {

	public List<?> getEmployeeLoginDetailsByEmpId(Integer empid, Integer index);

	public List<Employeeloginmaster> getAllEmployeeLoginDetails(Integer index);

	public String addLoginDetailsByEmpid(Employeeloginmaster employeeloginmaster);
	
}
