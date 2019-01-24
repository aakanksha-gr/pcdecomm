package com.pcdgroup.cms.PcdEcom.Employeelogin;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeloginServiceImpl implements EmployeeloginService {

	@Autowired
	EmployeeloginRepository employeeloginRepository;
	
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
	
}
