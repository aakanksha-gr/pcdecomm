package com.pcdgroup.cms.PcdEcom.Task;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends CrudRepository<Taskmaster, Integer> {
	
	@Query(nativeQuery = true, value = "SELECT taskid FROM taskmaster ORDER BY taskid DESC LIMIT 0, 1")
	Integer getMaxId();
	
	@Query(nativeQuery = true, value = "SELECT taskid, taskname, taskduraton, brand, tasktype, taskprocesstype FROM taskmaster WHERE taskid = ?1")
	Taskmaster getTask(Integer taskid);
	
	@Query(nativeQuery = true, value = "SELECT taskid, taskname, taskduraton, brand, tasktype, taskprocesstype FROM taskmaster WHERE taskid = ?1")
	List<Taskmaster> getAllTaskByTaskId(Integer taskid);
	
	@Query(nativeQuery = true, value = "SELECT taskid, taskname, taskduraton, brand, tasktype, taskprocesstype FROM taskmaster")
	List<Taskmaster> getAllTask();
	
	@Query(nativeQuery = true, value = "SELECT taskid, taskname, taskduraton, brand, tasktype, taskprocesstype FROM taskmaster WHERE LOWER(trim(brand = LOWER(trim(?1)))) AND LOWER(trim(tasktype = LOWER(trim(?2)))) LIMIT ?3, 10")
	List<Taskmaster> getTaskByWorkingArea(String brand, String tasktype, Integer index);
	
	@Query(nativeQuery = true, value = "SELECT taskid, taskname, taskduraton, brand, tasktype, taskprocesstype FROM taskmaster WHERE LOWER(trim(brand = LOWER(trim(?1)))) LIMIT 10")
	List<Taskmaster> getTaskByBrand(String brand);
	
}
