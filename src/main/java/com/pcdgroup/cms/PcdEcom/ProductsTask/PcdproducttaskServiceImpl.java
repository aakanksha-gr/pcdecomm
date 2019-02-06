package com.pcdgroup.cms.PcdEcom.ProductsTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.Task.TaskRepository;
import com.pcdgroup.cms.PcdEcom.Task.Taskmaster;

@Service
public class PcdproducttaskServiceImpl implements PcdproducttaskService {

	@Autowired
	PcdproducttaskRepository pcdproducttaskRepository;
	
	@Autowired
	TaskRepository taskRepository;
	
	Taskmaster taskmaster;
	
	@Override
	public String createPcdproducttask(Pcdproducttaskmaster pcdproducttaskmaster) {
		
		try {
			
			if(null != pcdproducttaskRepository.getMaxId()) {
				
				pcdproducttaskmaster.setPcdproducttaskid(pcdproducttaskRepository.getMaxId()+1);
				
			} else {
				
				pcdproducttaskmaster.setPcdproducttaskid(1);
				
			}
			
			pcdproducttaskRepository.save(pcdproducttaskmaster);
			
			return "PCD-Product task created..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public Pcdproducttaskmaster getPcdproducttask(Integer pcdproducttaskid) {
		
		try {
			
			if(null != pcdproducttaskid) {
				
				return pcdproducttaskRepository.getPcdproductTask(pcdproducttaskid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
	@Override
	public List<?> getAlltaskByProductId(Integer pid) {
		
		try {
			
			Integer tid;
			
			if(null != pid) {
				
				tid =  pcdproducttaskRepository.getTaskIdByProductId(pid);
				
				if(null != tid) {
					
					return taskRepository.getAllTaskByTaskId(tid);
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}


	@Override
	public List<Pcdproducttaskmaster> getAllPcdproducttask() {
		
		try {
			
			if(null != pcdproducttaskRepository.getAllPcdproductTask() && pcdproducttaskRepository.getAllPcdproductTask().size() > 0) {
				
				return pcdproducttaskRepository.getAllPcdproductTask();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public String deletePcdproducttask(Integer pcdproducttaskid) {
		
		try {
			
			if(null != pcdproducttaskid) {
				
				if(null != pcdproducttaskRepository.getPcdproductTask(pcdproducttaskid)) {
					
					pcdproducttaskRepository.deleteById(pcdproducttaskid);
					
					return "PCD-Product task removed..!";
					
				} else {
					
					return "No PCD-Product task avilable with provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String updatePcdproducttask(Pcdproducttaskmaster pcdproducttaskmaster, Integer pcdproducttaskid) {
		
		try {
			
			if(null != pcdproducttaskid) {
				
				pcdproducttaskmaster.setPcdproducttaskid(pcdproducttaskid);
				
				pcdproducttaskRepository.save(pcdproducttaskmaster);
			
				return "PCD-Product task updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

}
