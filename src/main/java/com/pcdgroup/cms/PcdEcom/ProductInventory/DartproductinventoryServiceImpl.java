package com.pcdgroup.cms.PcdEcom.ProductInventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DartproductinventoryServiceImpl implements DartproductinventoryService {

	@Autowired
	DartproductinventoryRepository dartproductinventoryRepository;

	@Override
	public String createDartproductInventory(Dartproductinventorymaster dartproductinventorymaster) {
		
		try {
			
			if(null != dartproductinventoryRepository.getMaxId()) {
				
				dartproductinventorymaster.setDartproductinventoryid(dartproductinventoryRepository.getMaxId()+1);
				
			} else {
				
				dartproductinventorymaster.setDartproductinventoryid(1);;
				
			}
			
			dartproductinventoryRepository.save(dartproductinventorymaster);
			
			return "DERT-Product Inventory created..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public Dartproductinventorymaster getDartproductInventory(Integer dartproductinventoryid) {
		
		try {
			
			if(null != dartproductinventoryid) {
				
				return dartproductinventoryRepository.getDartproductInventory(dartproductinventoryid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
		
	}

	@Override
	public List<Dartproductinventorymaster> getAllDartproductInventories() {
		
		try {
			
			if(null != dartproductinventoryRepository.getAllDartproductInventory() && dartproductinventoryRepository.getAllDartproductInventory().size() > 0) {
				
				return dartproductinventoryRepository.getAllDartproductInventory();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public String deleteDartproductInventory(Integer dartproductinventoryid) {
		
		try {
			
			if(null != dartproductinventoryid) {
					   
				if(null != dartproductinventoryRepository.getDartproductInventory(dartproductinventoryid)) {
					
					dartproductinventoryRepository.deleteById(dartproductinventoryid);
					
					return "DERT-Product inventory removed..!";
					
				} else {
					
					return "No DERT-Product inventory avilable with provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String updateDartproductInventory(Dartproductinventorymaster dartproductinventorymaster,
			Integer dartproductinventoryid) {
		
		try {
			
			if(null != dartproductinventoryid) {
				
				dartproductinventorymaster.setDartproductinventoryid(dartproductinventoryid);
				
				dartproductinventoryRepository.save(dartproductinventorymaster);
				
				return "DERT-product inventory updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}
	
	
	
}
