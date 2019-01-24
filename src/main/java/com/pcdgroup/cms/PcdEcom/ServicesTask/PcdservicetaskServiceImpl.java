package com.pcdgroup.cms.PcdEcom.ServicesTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PcdservicetaskServiceImpl implements PcdservicetaskService {

	@Autowired
	PcdservicetaskRepository pcdservicetaskRepository;
	
	@Override
	public String createPcdserviceTask(Pcdservicetaskmaster pcdservicetaskmaster) {
		
		try {
			
			if(null != pcdservicetaskRepository.getMaxId()) {
				
				pcdservicetaskmaster.setPcdservicetaskid(pcdservicetaskRepository.getMaxId()+1);
				
			} else {
				
				pcdservicetaskmaster.setPcdservicetaskid(1);
				
			}
			
			pcdservicetaskRepository.save(pcdservicetaskmaster);
			
			return "PCD-Service task created..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public Pcdservicetaskmaster getPcdserviceTask(Integer pcdservicetaskid) {
		
		try {
			
			if(null != pcdservicetaskid) {
				
				return pcdservicetaskRepository.getPcdserviceTask(pcdservicetaskid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
	@Override
	public List<?> getPcdserviceTaskByServiceid(Integer pcdserviceid) {
		// TODO Auto-generated method stub
		
		try {
		
			if(null != pcdserviceid) {
				
				return pcdservicetaskRepository.getAllPcdserviceByServiceid(pcdserviceid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}


	@Override
	public List<Pcdservicetaskmaster> getAllPcdserviceTasks() {
		
		try {
			
			if(null != pcdservicetaskRepository.getAllPcdserviceTask() && pcdservicetaskRepository.getAllPcdserviceTask().size() > 0) {
				
				return pcdservicetaskRepository.getAllPcdserviceTask();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public String deletePcdserviceTask(Integer pcdservicetaskid) {
		
		try {
			
			if(null != pcdservicetaskid) {
				
				if(null != pcdservicetaskRepository.getPcdserviceTask(pcdservicetaskid)) {
					
					pcdservicetaskRepository.deleteById(pcdservicetaskid);
					
					return "PCD-Service task removed..!";
					
				} else {
					
					return "No PCD-Service task avilable with provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String updatePcdserviceTask(Pcdservicetaskmaster pcdservicetaskmaster, Integer pcdservicetaskid) {
		
		try {
			
			if(null != pcdservicetaskid) {
				
				pcdservicetaskmaster.setPcdservicetaskid(pcdservicetaskid);
				
				pcdservicetaskRepository.save(pcdservicetaskmaster);
			
				return "PCD-Service task updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

}
