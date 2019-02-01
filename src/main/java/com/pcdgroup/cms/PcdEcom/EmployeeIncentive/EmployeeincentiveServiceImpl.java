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

	@Override
	public HashMap<?,?> getAllEmployeeIncentiveByMonth(EmployeeIncentiveBean employeeIncentiveBean) {
		
		HashMap<String, String> gettotalincentiveofallemployees;
		
		try {
		
			gettotalincentiveofallemployees = new HashMap<>();
			
			if(null != employeeIncentiveBean.getMonth()) {
				
				gettotalincentiveofallemployees.put("month", employeeIncentiveBean.getMonth());
				
				if(null != employeeincentiveRepository.getAllEmployeeincentiveByMonth(employeeIncentiveBean.getMonth()))
					
					gettotalincentiveofallemployees.put("totalincentive", String.valueOf(employeeincentiveRepository.getAllEmployeeincentiveByMonth(employeeIncentiveBean.getMonth())));
				
				return gettotalincentiveofallemployees;
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;

	}
	
	@Override
	public HashMap<?,?> getEmployeeIncentiveByYear(EmployeeIncentiveBean employeeIncentiveBean) {
		
		HashMap<String, String> getyearlyemployeeinentive;
		
		try {
				
			getyearlyemployeeinentive = new HashMap<>();
			
			if(null != employeeIncentiveBean.getId() && null != employeeIncentiveBean.getYear()) {
				
				getyearlyemployeeinentive.put("empid", employeeIncentiveBean.getId());
				
				getyearlyemployeeinentive.put("year", employeeIncentiveBean.getYear());
				
				if(null != employeeincentiveRepository.getEmployeeincentiveByYear(employeeIncentiveBean.getYear(), Integer.parseInt(employeeIncentiveBean.getId()))) {
					
					getyearlyemployeeinentive.put("totalincentive", String.valueOf(employeeincentiveRepository.getEmployeeincentiveByYear(employeeIncentiveBean.getYear(), Integer.parseInt(employeeIncentiveBean.getId()))));
					
					return getyearlyemployeeinentive;
				
				}
			
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public HashMap<?,?> getAllEmployeeIncentiveByYear(EmployeeIncentiveBean employeeIncentiveBean) {
		
		HashMap<String, String> getyearlyallemployeeinentive;
		
		try {
			
			getyearlyallemployeeinentive = new HashMap<>();
		
			if(null != employeeIncentiveBean.getYear()) {
				
				getyearlyallemployeeinentive.put("year", employeeIncentiveBean.getYear());
				
				if(null != employeeincentiveRepository.getAllEmployeeincentiveByYear(employeeIncentiveBean.getYear())) {
					
					getyearlyallemployeeinentive.put("totalincentive", String.valueOf(employeeincentiveRepository.getAllEmployeeincentiveByYear(employeeIncentiveBean.getYear())));
					
					return getyearlyallemployeeinentive;
				
				}
			
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;

	}
	
	@Override
	public HashMap<?,?> getAllEmployeeIncentiveByMonthYear(EmployeeIncentiveBean employeeIncentiveBean) {
		
		HashMap<String, String> getmonthyearlyallemployeeinentive;
		
		try {
			
			getmonthyearlyallemployeeinentive = new HashMap<>();
		
			if(null != employeeIncentiveBean.getMonth() && null != employeeIncentiveBean.getYear()) {
				
				getmonthyearlyallemployeeinentive.put("month", employeeIncentiveBean.getMonth());
				
				getmonthyearlyallemployeeinentive.put("year", employeeIncentiveBean.getYear());
				
				if(null != employeeincentiveRepository.getAllEmployeeincentiveByMonthYear(employeeIncentiveBean.getMonth(), employeeIncentiveBean.getYear())) {
					
					getmonthyearlyallemployeeinentive.put("totalincentive", String.valueOf(employeeincentiveRepository.getAllEmployeeincentiveByMonthYear(employeeIncentiveBean.getMonth(), employeeIncentiveBean.getYear())));
					
					return getmonthyearlyallemployeeinentive;
				
				}
			
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;

	}
	
	public HashMap<?,?> getEmployeeIncentiveByMonthYear(EmployeeIncentiveBean employeeIncentiveBean) {
		
		HashMap<String, String> getmonthyearlyemployeeinentive;
		
		try {
			
			getmonthyearlyemployeeinentive = new HashMap<>();
		
			if(null != employeeIncentiveBean.getMonth() && null != employeeIncentiveBean.getYear() && null != employeeIncentiveBean.getId()) {
				
				getmonthyearlyemployeeinentive.put("empid", employeeIncentiveBean.getId());
				
				getmonthyearlyemployeeinentive.put("month", employeeIncentiveBean.getMonth());
				
				getmonthyearlyemployeeinentive.put("year", employeeIncentiveBean.getYear());
				
				if(null != employeeincentiveRepository.getEmployeeincentiveByMonthYear(employeeIncentiveBean.getMonth(), employeeIncentiveBean.getYear(), Integer.parseInt(employeeIncentiveBean.getId()))) {
					
					getmonthyearlyemployeeinentive.put("totalincentive", String.valueOf(employeeincentiveRepository.getEmployeeincentiveByMonthYear(employeeIncentiveBean.getMonth(), employeeIncentiveBean.getYear(), Integer.parseInt(employeeIncentiveBean.getId()))));
					
					return getmonthyearlyemployeeinentive;
				
				}
			
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;

	}
 	
}
