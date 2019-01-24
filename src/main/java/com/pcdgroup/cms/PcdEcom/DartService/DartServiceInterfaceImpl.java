package com.pcdgroup.cms.PcdEcom.DartService;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DartServiceInterfaceImpl implements DartServiceInterface {

	@Autowired
	DartServiceRepository dartServiceRepository;
	
	@Autowired
    EntityManager em;
	
	@Override
	public List<?> getAllDartService(int startindx) {
		
		List<Dartservicemaster> getAllService;
		try {
				
			getAllService = new ArrayList<>();
			
			if(null != String.valueOf(startindx)) {
				
				getAllService = dartServiceRepository.getAllDartServices(startindx);
				
				if(null != getAllService && getAllService.size() > 0) {
					
					return getAllService;
				
				} else {
					
					System.out.println("No more records are avilable..!");
					
				}
				
			}
		
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println(e);
		
		}
	
		return null;
	
	}

	@Override
	public List<?> getDartServiceById(Integer serviceid) {
		
		List<Dartservicemaster> dartServiceById;
		
		try {
			
			dartServiceById = new ArrayList<>();
			
			if(null != String.valueOf(dartServiceById)) {
				
				dartServiceById = dartServiceRepository.getDartServiceById(serviceid);
				
				if(dartServiceById != null && dartServiceById.size() > 0) {
					
					return dartServiceById;
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	public String addPcdService(Dartservicemaster dartservicemaster) {
		
		try {
			
			if(null != dartServiceRepository.getMaxId()) {
				
				dartservicemaster.setServiceid(dartServiceRepository.getMaxId()+1);
				
			} else {
				
				dartservicemaster.setServiceid(1);
				
			}
			
			dartServiceRepository.save(dartservicemaster);
			
			return "Record Added";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong";
		
	}

	public String updateServiceById(Dartservicemaster dartservicemaster, Integer id) {
		
		if(null != id) {
			
			dartservicemaster.setServiceid(id);
			dartServiceRepository.save(dartservicemaster);
			
			return "Service updated";
			
		}
		
		return null;
	}

	public String deleteDartService(Integer serviceid) {
		
		try {
			
			Integer dsid = dartServiceRepository.getServiceId(serviceid);
			if(null != dsid) {
				
				dartServiceRepository.deleteById(dsid);
				
				return "Dart-Servce removed..!";
				
			} else {
				
				return "Dart-Servce already deleted or not avileble with provided service id..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	
	}	
	
}
