package com.pcdgroup.cms.PcdEcom.Task;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

	@Autowired
	TaskServiceImpl taskServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/createTask")
	public String createTask(@RequestBody Taskmaster taskmaster) {
	
		return taskServiceImpl.createTask(taskmaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getTask/{taskid}")
	public Taskmaster getTask(@PathVariable Integer taskid) {
		
		return taskServiceImpl.getTask(taskid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getTaskByWorkingarea/{brand}/{tasktype}/{index}")
	public List<?> getTaskByWorkingarea(@PathVariable String brand, @PathVariable String tasktype, @PathVariable Integer index) {
		
		return taskServiceImpl.getTaskByWorkingarea(brand, tasktype, index);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getTaskByBrand/{brand}")
	public List<?> getTaskByWorkingarea(@PathVariable String brand) {
		
		return taskServiceImpl.getTaskByBrand(brand);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllTask")
	public List<?> getAllTask() {
		
		return taskServiceImpl.getAllTasks();
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateTask/{taskid}")
	public String updateTask(@RequestBody Taskmaster taskmaster, @PathVariable Integer taskid) {
		
		return taskServiceImpl.updateTask(taskmaster, taskid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteTaskById/{taskid}")
	public String deleteTask(@PathVariable Integer taskid) {
		
		return taskServiceImpl.deleteTask(taskid);
		
	}
	
}
