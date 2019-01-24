package com.pcdgroup.cms.PcdEcom.EmployeeIncentive;

import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeincentiveServiceImpl implements EmployeeincentiveService {

	@Autowired
	EmployeeincentiveRepository employeeincentiveRepository;
	
	@Override
	public String addEmployeeIncentive(EmployeeIncentivemaster employeeIncentivemaster, Integer empid) {
		
		Calendar calobj = Calendar.getInstance();
		
		try {
			
			if(null != empid) {
				
				if(null != employeeincentiveRepository.getMaxId()) {
					
					employeeIncentivemaster.setEmpincentiveid(employeeincentiveRepository.getMaxId()+1);
					
				} else {
					
					employeeIncentivemaster.setEmpincentiveid(1);
					
				}
				
				employeeIncentivemaster.setEmployeeid(empid);
				
				employeeIncentivemaster.setIncentivedate(calobj.getTime());
				
				employeeincentiveRepository.save(employeeIncentivemaster);
				
				return "Incentive added successfully..!";
				
			} else {
				
				return "Employee id must needed to add incentive..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}
	
	@Override
	public List<?> getAllEmployeeIncentive(Integer index) {
		
		try {
			
			if(null != employeeincentiveRepository.getAllEmployeeincentive(index) && employeeincentiveRepository.getAllEmployeeincentive(index).size() > 0) {
				
				return employeeincentiveRepository.getAllEmployeeincentive(index);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}
	
	@Override
	public EmployeeIncentivemaster getEmployeeIncentiveById(Integer empid) {
		
		try {
			
			if(null != empid) {
				
				if(null != employeeincentiveRepository.getEmployeeincentiveById(empid)) {
					
					return employeeincentiveRepository.getEmployeeincentiveById(empid);
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}
	
	@Override
	public HashMap<?,?> getEmployeeIncentiveByMonth(EmployeeIncentiveBean employeeIncentiveBean) {
		
		HashMap<String, String> gettotalincentive;
		
		try {
				
			gettotalincentive = new HashMap<>();
			
				if(null != employeeIncentiveBean.getId() && null != employeeIncentiveBean.getMonth()) {
					
					gettotalincentive.put("empid", employeeIncentiveBean.getId());
					gettotalincentive.put("month", employeeIncentiveBean.getMonth());
					if(null != employeeincentiveRepository.getEmployeeincentiveByMonth(Integer.parseInt(employeeIncentiveBean.getMonth()), Integer.parseInt(employeeIncentiveBean.getId()))) {
						gettotalincentive.put("totalincentive", String.valueOf(employeeincentiveRepository.getEmployeeincentiveByMonth(Integer.parseInt(employeeIncentiveBean.getMonth()), Integer.parseInt(employeeIncentiveBean.getId()))));
					} else {
						gettotalincentive.put("totalincentive", "0");
					}
					
					return gettotalincentive;
					
				}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	/*@Override
	public List<EmployeeIncentivemaster> getAllEmployeeIncentiveByMonth(EmployeeIncentivemaster employeeIncentivemaster) {
		
		try {
		
			if(null != employeeIncentivemaster.getIncentivedate()) {
				
				return employeeincentiveRepository.getAllEmployeeincentiveByMonth(employeeIncentivemaster.getIncentivedate());
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;

	}*/
	
	/*@Override
	public List<EmployeeIncentivemaster> getEmployeeIncentiveByYear(EmployeeIncentivemaster employeeIncentivemaster) {
		
		try {
				
				if(null != employeeIncentivemaster.getIncentivedate() && null != employeeIncentivemaster.getEmployeeid()) {
					
					return employeeincentiveRepository.getEmployeeincentiveByYear(employeeIncentivemaster.getIncentivedate(), employeeIncentivemaster.getEmployeeid());
					
				}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public List<EmployeeIncentivemaster> getAllEmployeeIncentiveByYear(EmployeeIncentivemaster employeeIncentivemaster) {
		
		try {
		
			if(null != employeeIncentivemaster.getIncentivedate()) {
				
				return employeeincentiveRepository.getAllEmployeeincentiveByYear(employeeIncentivemaster.getIncentivedate());
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;

	}*/
 	
}
