package com.pcdgroup.cms.PcdEcom.Employeelogin;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeloginServiceImpl implements EmployeeloginService {

	@Autowired
	EmployeeloginRepository employeeloginRepository;
	
	@Override
	public List<Employeeloginmaster> getAllEmployeeLoginDetails(Integer index) {
		
		List<Employeeloginmaster> getAllLogindtls;
		
		try {
			
			getAllLogindtls = new ArrayList<>();
			
			getAllLogindtls = employeeloginRepository.getAllLoginDetails(index);
			
			if(null != getAllLogindtls && getAllLogindtls.size() > 0) {
				
				return getAllLogindtls;
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public List<?> getEmployeeLoginDetailsByEmpId(Integer empid, Integer index) {
		
		List<Employeeloginmaster> getEmpLoginDetails;
		
		try {
			
			getEmpLoginDetails = new ArrayList<>();
			
			if(null != empid) {
				
				getEmpLoginDetails = employeeloginRepository.getEmployeeLoginDetailsByEmpid(empid, index);	
				
				if(null != getEmpLoginDetails && getEmpLoginDetails.size() > 0) {
					
					return getEmpLoginDetails;
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public String addLoginDetailsByEmpid(Employeeloginmaster employeeloginmaster) {
		
		Calendar calobj = Calendar.getInstance();
		
		try {
			
			if(null != employeeloginmaster.getEmpid()) {
				
				if(null != employeeloginRepository.getMaxId()) {
					
					employeeloginmaster.setEmployeeliginid(employeeloginRepository.getMaxId()+1);
					
				} else {
					
					employeeloginmaster.setEmployeeliginid(1);
					
				}
				
				employeeloginmaster.setServicestartingtime(calobj.getTime());
				
				employeeloginRepository.save(employeeloginmaster);
				
				return "Employee login details added..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
}
