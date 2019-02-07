package com.pcdgroup.cms.PcdEcom.Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	TaskRepository taskRepository;

	@Override
	public String createTask(Taskmaster taskmaster) {
		
		try {
			
			if(null != taskRepository.getMaxId()) {
				
				taskmaster.setTaskid(taskRepository.getMaxId()+1);
				
			} else {
				
				taskmaster.setTaskid(1);
				
			}
			
			taskRepository.save(taskmaster);
			
			return "Task created..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public Taskmaster getTask(Integer taskid) {
		
		try {
			
			if(null != taskid) {
				
				return taskRepository.getTask(taskid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public List<Taskmaster> getAllTasks(Integer index) {
		
		try {
			
			if(null != taskRepository.getAllTask(index) && taskRepository.getAllTask(index).size() > 0) {
				
				return taskRepository.getAllTask(index);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

	@Override
	public String deleteTask(Integer taskid) {
		
		try {
			
			if(null != taskid) {
				
				if(null != taskRepository.getTask(taskid)) {
					
					taskRepository.deleteById(taskid);
					
					return "Task removed..!";
					
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
	public String updateTask(Taskmaster taskmaster, Integer taskid) {
		
		try {
			
			if(null != taskid) {
				
				taskmaster.setTaskid(taskid);
				
				taskRepository.save(taskmaster);
			
				return "Task updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	
	}

	@Override
	public List<?> getTaskByWorkingarea(String brand, String tasktype, Integer index) {
		
		try {
			
			if(null != brand && null != tasktype && null != index) {
				
				if(null != taskRepository.getTaskByWorkingArea(brand, tasktype, index) && taskRepository.getTaskByWorkingArea(brand, tasktype, index).size() > 0) {
					
					return taskRepository.getTaskByWorkingArea(brand, tasktype, index);
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<Taskmaster> getTaskByBrand(String brand) {
		
		try {
			
			if(null != brand && brand.trim().length() > 0) {
				
				return taskRepository.getTaskByBrand(brand);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
}
