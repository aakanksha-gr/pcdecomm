package com.pcdgroup.cms.PcdEcom.ProductsTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DartproducttaskServiceImpl implements DartproducttaskService {

	@Autowired
	DartproducttaskRepository dartproducttaskRepository;
	
	@Override
	public String createDartproducttask(Dartproducttaskmaster dartproducttaskmaster) {
		
		try {
			
			if(null != dartproducttaskRepository.getMaxId()) {
				
				dartproducttaskmaster.setDartproducttaskid(dartproducttaskRepository.getMaxId()+1);
				
			} else {
				
				dartproducttaskmaster.setDartproducttaskid(1);
				
			}
			
			dartproducttaskRepository.save(dartproducttaskmaster);
			
			return "DERT-Product task created..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public Dartproducttaskmaster getDartproducttask(Integer dartproducttaskid) {
		
		try {
			
			if(null != dartproducttaskid) {
				
				return dartproducttaskRepository.getDartproductTask(dartproducttaskid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
	@Override
	public List<?> getDartproducttaskByProductid(Integer dartproductid) {
		
		try {
			
			if(null != dartproductid) {
				
				return dartproducttaskRepository.getDartproductTaskByProductid(dartproductid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<Dartproducttaskmaster> getAllDartproducttask() {
		
		try {
			
			if(null != dartproducttaskRepository.getAllDartproductTask() && dartproducttaskRepository.getAllDartproductTask().size() > 0) {
				
				return dartproducttaskRepository.getAllDartproductTask();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public String deleteDartproducttask(Integer dartproducttaskid) {
		
		try {
			
			if(null != dartproducttaskid) {
				
				if(null != dartproducttaskRepository.getDartproductTask(dartproducttaskid)) {
					
					dartproducttaskRepository.deleteById(dartproducttaskid);
					
					return "DERT-Product task removed..!";
					
				} else {
					
					return "No DERT-Product task avilable with provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String updateDartproducttask(Dartproducttaskmaster dartproducttaskmaster, Integer dartproducttaskid) {
		
		try {
			
			if(null != dartproducttaskid) {
				
				dartproducttaskmaster.setDartproducttaskid(dartproducttaskid);
				
				dartproducttaskRepository.save(dartproducttaskmaster);
			
				return "DERT-Product task updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

}
