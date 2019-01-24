package com.pcdgroup.cms.PcdEcom.Vendorinventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VendorinventoryServiceImpl implements VendorinventoryService {

	@Autowired
	VendorinventoryRepository vendorinventoryRepository;

	@Override
	public String createVendorinventory(Vendorinventorymaster vendorinventorymaster) {
		
		try {
			
			if(null != vendorinventoryRepository.getMaxId()) {
				
				vendorinventorymaster.setVendorinventoryid(vendorinventoryRepository.getMaxId()+1);
				
			} else {
				
				vendorinventorymaster.setVendorinventoryid(1);
				
			}
			
			vendorinventoryRepository.save(vendorinventorymaster);
			
			return "Vendor inventory created..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public Vendorinventorymaster getVendorinventory(Integer vendorinventoryid) {
		
		try {
			
			if(null != vendorinventoryid) {
				
				return vendorinventoryRepository.getVendorinventory(vendorinventoryid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<Vendorinventorymaster> getAllVendorinventory() {
		
		try {
			
			if(null != vendorinventoryRepository.getAllVendorinventory() && vendorinventoryRepository.getAllVendorinventory().size() > 0) {
				
				return vendorinventoryRepository.getAllVendorinventory();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

	@Override
	public String deleteVendorinventory(Integer vendorinventoryid) {
		
		try {
			
			if(null != vendorinventoryid) {
				
				if(null != vendorinventoryRepository.getVendorinventory(vendorinventoryid)) {
					
					vendorinventoryRepository.deleteById(vendorinventoryid);
					
					return "Vendor inventory removed..!";
					
				} else {
					
					return "No vendor inventory avilable with provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String updateVendorinventory(Vendorinventorymaster vendorinventorymaster, Integer vendorinventoryid) {
		
		try {
			
			if(null != vendorinventoryid) {
				
				vendorinventorymaster.setVendorinventoryid(vendorinventoryid);
				
				vendorinventoryRepository.save(vendorinventorymaster);
			
				return "Vendor inventory updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}
	
}
