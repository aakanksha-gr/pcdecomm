package com.pcdgroup.cms.PcdEcom.ServicesTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DartservicetaskServiceImpl implements DartservicetaskService {

	@Autowired
	DartservicetaskRepository dartservicetaskRepository;
	
	@Override
	public String createDartserviceTask(Dartservicetaskmaster dartservicetaskmaster) {
		
		try {
			
			if(null != dartservicetaskRepository.getMaxId()) {
				
				dartservicetaskmaster.setDartservicetaskid(dartservicetaskRepository.getMaxId()+1);
				
			} else {
				
				dartservicetaskmaster.setDartservicetaskid(1);
				
			}
			
			dartservicetaskRepository.save(dartservicetaskmaster);
			
			return "DERT-Service task created..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public Dartservicetaskmaster getDartserviceTask(Integer dartservicetaskid) {
		
		try {
			
			if(null != dartservicetaskid) {
				
				return dartservicetaskRepository.getDartserviceTask(dartservicetaskid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<?> getDartserviceTaskByServiceid(Integer dartserviceid) {
	
		try {
			
			if(null != dartserviceid) {
				
				return dartservicetaskRepository.getAllServiceByServiceId(dartserviceid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
	@Override
	public List<Dartservicetaskmaster> getAllDartserviceTasks() {
		
		try {
			
			if(null != dartservicetaskRepository.getAllDartserviceTask() && dartservicetaskRepository.getAllDartserviceTask().size() > 0) {
				
				return dartservicetaskRepository.getAllDartserviceTask();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public String deleteDartserviceTask(Integer dartservicetaskid) {
		
		try {
			
			if(null != dartservicetaskid) {
				
				if(null != dartservicetaskRepository.getDartserviceTask(dartservicetaskid)) {
					
					dartservicetaskRepository.deleteById(dartservicetaskid);
					
					return "DERT-Service task removed..!";
					
				} else {
					
					return "No DERT-Service task avilable with provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String updateDartserviceTask(Dartservicetaskmaster dartservicetaskmaster, Integer dartservicetaskid) {
		
		try {
			
			if(null != dartservicetaskid) {
				
				dartservicetaskmaster.setDartservicetaskid(dartservicetaskid);
				
				dartservicetaskRepository.save(dartservicetaskmaster);
			
				return "DERT-Service task updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

}
