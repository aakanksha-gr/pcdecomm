package com.pcdgroup.cms.PcdEcom.EmployeeTasks;

import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeetaskServiceImpl implements EmployeetaskService {
	
	@Autowired
	EmployeetaskRepository employeetaskRepository;
	
	@Override
	public String createEmployeetask(Employeetaskmaster employeetaskmaster) {
		
		Calendar calobj = Calendar.getInstance();
		
		try {
			
			if(null != employeetaskRepository.getMaxId()) {
				
				employeetaskmaster.setEmployeetaskid(employeetaskRepository.getMaxId()+1);
				
			} else {
				
				employeetaskmaster.setEmployeetaskid(1);
				
			}
			
			employeetaskmaster.setTaskdatetime(calobj.getTime());
			
			employeetaskRepository.save(employeetaskmaster);
			
			return "Employee task created..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	
	}

	@Override
	public Employeetaskmaster getEmployeetask(Integer emptaskid) {
		
		try {
				
			if(null != emptaskid) {
				
				return employeetaskRepository.getEmployeetask(emptaskid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}
	
	public List<Employeetaskmaster> getEmployeetaskByEmpid(Integer empid) {
		
		try {
			
			if(null != empid) {
				
				return employeetaskRepository.getEmployeetaskByEmpid(empid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<Employeetaskmaster> getAllEmployeeTasks() {
		
		try {
			
			if(null != employeetaskRepository.getAllEmployeetask() && employeetaskRepository.getAllEmployeetask().size() > 0) {
				
				return employeetaskRepository.getAllEmployeetask();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public String deleteEmployeetask(Integer emptaskid) {
		
		try {
			
			if(null != emptaskid) {
				
				if(null != employeetaskRepository.getEmployeetask(emptaskid)) {
					
					employeetaskRepository.deleteById(emptaskid);
					
					return "Employee task removed..!";
					
				} else {
					
					return "No task avilable with provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String updateEmployeetask(Employeetaskmaster employeetaskmaster, Integer emptaskid) {

		Calendar calobj = Calendar.getInstance();
		
		try {
			
			if(null != emptaskid) {
				
				employeetaskmaster.setEmployeetaskid(emptaskid);
				
				employeetaskmaster.setTaskdatetime(calobj.getTime());
				
				employeetaskRepository.save(employeetaskmaster);
			
				return "Employee task updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public List<Employeetaskmaster> getAllEmployeePendingtasks() {
		
		try {
			
			if(null != employeetaskRepository.getAllEmployeependingtask() && employeetaskRepository.getAllEmployeependingtask().size() > 0) {
			
				return employeetaskRepository.getAllEmployeependingtask();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public List<Employeetaskmaster> getAllEmployeePendingtasksByDeadline() {
		
		try {
			
			if(null != employeetaskRepository.getAllEmployeependingtaskByDeadline() && employeetaskRepository.getAllEmployeependingtaskByDeadline().size() > 0) {
				
				return employeetaskRepository.getAllEmployeependingtaskByDeadline();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

}
