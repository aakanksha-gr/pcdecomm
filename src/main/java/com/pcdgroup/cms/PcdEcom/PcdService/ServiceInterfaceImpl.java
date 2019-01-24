package com.pcdgroup.cms.PcdEcom.PcdService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceInterfaceImpl implements ServiceInterface {

	@Autowired
	ServiceRepository serviceRepository;
	
	@Override
	public List<?> getAllPcdService(int startindx) {
		
		List<Servicemaster> getAllServices;
		
		try {
			
			getAllServices = new ArrayList<>();
			
			if(null != String.valueOf(startindx)) {
			
				getAllServices = serviceRepository.getAllPcdServices(startindx);
				
				if(null != getAllServices && getAllServices.size() > 0) {
					
					return getAllServices;
				
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
	public List<?> getPcdServiceById(Integer serviceid) {
		
		List<Servicemaster> pcdServiceById;
		
		try {
			
			pcdServiceById = new ArrayList<>();
			
			if(null != String.valueOf(serviceid)) {
				
				pcdServiceById = serviceRepository.getPcdServiceById(serviceid);
				
				if(pcdServiceById != null && pcdServiceById.size() > 0) {
					
					return pcdServiceById;
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public String addPcdService(Servicemaster servicemaster) {
				
		try {
			
			if(null != serviceRepository.getMaxId()) {
				
				servicemaster.setServiceid(serviceRepository.getMaxId()+1);
				
			} else {
				
				servicemaster.setServiceid(1);
				
			}
			
			serviceRepository.save(servicemaster);
			return "Record Added";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	public String updateServiceById(Servicemaster servicemaster, Integer id) {
		
		if(null != id) {
			
			servicemaster.setServiceid(id);
			serviceRepository.save(servicemaster);
			
			return "Service updated";
			
		}
		
		return null;
	}

	public String deletePcdService(Integer serviceid) {
		
		try {
		
			Integer dsid = serviceRepository.getServiceId(serviceid);
			
			if(null != dsid) {
				
				serviceRepository.deleteById(dsid);
				
				return "Pcd-Servce removed..!";
				
			} else {
				
				return "Pcd-Servce already deleted or not avileble with provided service id..!";
				
			}
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
	
		}
		
		return null;
	}

}
