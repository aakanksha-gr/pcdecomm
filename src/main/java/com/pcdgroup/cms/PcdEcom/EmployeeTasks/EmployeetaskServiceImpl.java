package com.pcdgroup.cms.PcdEcom.EmployeeTasks;

import java.util.ArrayList;
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
	
	public List<Employeetaskmaster> getEmployeetaskByEmpid(Integer empid, Integer index) {
		
		try {
			
			if(null != empid) {
				
				return employeetaskRepository.getEmployeetaskByEmpid(empid, index);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<Employeetaskmaster> getAllEmployeeTasks(Integer index) {
		
		try {
			
			if(null != employeetaskRepository.getAllEmployeetask(index) && employeetaskRepository.getAllEmployeetask(index).size() > 0) {
				
				return employeetaskRepository.getAllEmployeetask(index);
				
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
	
	@Override
	public List<?> getAllEmployeeCompletedtasks() {
		
		List<Employeetaskmaster> getAllCompletedTask;
		
		try {
			
			getAllCompletedTask = new ArrayList<>();
			
			getAllCompletedTask = employeetaskRepository.getAllEmployeecompletedtask();
			
			if(null != getAllCompletedTask && getAllCompletedTask.size() > 0) {
			
				return getAllCompletedTask;
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public List<?> getAllEmployeependingtaskByEmpid(Integer empid) {
		
		List<Employeetaskmaster> getPendingTaskByEmpid;
		
		try {
			
			getPendingTaskByEmpid = new ArrayList<>();
			
			if(null != empid) {
			
				getPendingTaskByEmpid = employeetaskRepository.getAllEmployeependingtaskByEmpid(empid);
				
				if(null != getPendingTaskByEmpid && getPendingTaskByEmpid.size() > 0) {
					
					return getPendingTaskByEmpid;
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
	@Override
	public List<?> getEmployeecompletedByEmpid(Integer empid) {
		
		List<Employeetaskmaster> getCompletedTaskByEmpid;
		
		try {
			
			getCompletedTaskByEmpid = new ArrayList<>();
			
			if(null != empid) {
			
				getCompletedTaskByEmpid = employeetaskRepository.getEmployeeCompletedtaskByEmpid(empid);
				
				if(null != getCompletedTaskByEmpid && getCompletedTaskByEmpid.size() > 0) {
					
					return getCompletedTaskByEmpid;
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
	@Override
	public List<?> getAllEmployeependingtaskCrossedDeadlineByEmpid(Integer empid) {
		
		List<Employeetaskmaster> getPendingTaskCrossedDeadlineByEmpid;
		
		try {
			
			getPendingTaskCrossedDeadlineByEmpid = new ArrayList<>();
			
			if(null != empid) {
			
				getPendingTaskCrossedDeadlineByEmpid = employeetaskRepository.getAllEmployeependingtaskCrossedDeadlineByEmpid(empid);
				
				if(null != getPendingTaskCrossedDeadlineByEmpid && getPendingTaskCrossedDeadlineByEmpid.size() > 0) {
					
					return getPendingTaskCrossedDeadlineByEmpid;
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public Integer countTotalNoOfPendingTasksByEmpid(Integer empid) {

		Integer countOfPendingtasksByEmpid;
		
		try {
			
			if(null != empid) {
				
				countOfPendingtasksByEmpid = employeetaskRepository.countTotalNoOfPendingTasksByEmpid(empid);
				
				if(null != countOfPendingtasksByEmpid) {
					
					return countOfPendingtasksByEmpid;
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}	

		return null;
	}

	@Override
	public Integer countTotalNoOfCompletedTasksEmpid(Integer empid) {

		Integer countOfCompletedtasksByEmpid;
		
		try {
			
			if(null != empid) {
				
				countOfCompletedtasksByEmpid = employeetaskRepository.countTotalNoOfCompletedTasksEmpid(empid);
				
				if(null != countOfCompletedtasksByEmpid) {
					
					return countOfCompletedtasksByEmpid;
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}	
		
		return null;
	}

	@Override
	public Integer countTotalNoOfPendingTasks() {

	Integer countOfPendingtasks;
		
	try {
			
			countOfPendingtasks = employeetaskRepository.countTotalNoOfPendingTasks();
				
			if(null != countOfPendingtasks) {
					
				return countOfPendingtasks;
					
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}	
		
		return null;
	}

	@Override
	public Integer countTotalNoOfCompletedTasks() {

		Integer countOfCompletedtasks;
		
		try {
				
				countOfCompletedtasks = employeetaskRepository.countTotalNoOfCompletedTasks();
					
				if(null != countOfCompletedtasks) {
						
					return countOfCompletedtasks;
						
				}
				
			} catch (Exception e) {
				
				e.printStackTrace();
				System.out.println(e);
				
			}	
		
		return null;
	}

}
