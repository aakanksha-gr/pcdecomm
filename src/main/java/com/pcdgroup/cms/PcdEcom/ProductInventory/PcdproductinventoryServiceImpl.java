package com.pcdgroup.cms.PcdEcom.ProductInventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PcdproductinventoryServiceImpl implements PcdproductinventoryService {

	@Autowired
	PcdproductinventoryRepository productinventoryRepository;

	@Override
	public String createProductInventory(Pcdproductinventorymaster productinventorymaster) {
		
		try {
			
			if(null != productinventoryRepository.getMaxId()) {
				
				productinventorymaster.setPcdproductinventoryid(productinventoryRepository.getMaxId()+1);
				
			} else {
				
				productinventorymaster.setPcdproductinventoryid(1);
				
			}
			
			productinventoryRepository.save(productinventorymaster);
			
			return "PCD-Product Inventory created..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public Pcdproductinventorymaster getProductInventory(Integer productinventoryid) {
		
		try {
			
			if(null != productinventoryid) {
				
				return productinventoryRepository.getPcdproductInventory(productinventoryid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<Pcdproductinventorymaster> getAllProductInventories() {
		
		try {
			
			if(null != productinventoryRepository.getAllPcdproductInventory() && productinventoryRepository.getAllPcdproductInventory().size() > 0) {
				
				return productinventoryRepository.getAllPcdproductInventory();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

	@Override
	public String deleteProductInventory(Integer productInventoryid) {
		
		try {
			
			if(null != productInventoryid) {
					   
				if(null != productinventoryRepository.getPcdproductInventory(productInventoryid)) {
					
					productinventoryRepository.deleteById(productInventoryid);;
					
					return "PCD-Product inventory removed..!";
					
				} else {
					
					return "No PCD-Product inventory avilable with provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String updateProductInventory(Pcdproductinventorymaster productinventorymaster, Integer productinventoryid) {
		
		try {
			
			if(null != productinventoryid) {
				
				productinventorymaster.setPcdproductinventoryid(productinventoryid);
				
				productinventoryRepository.save(productinventorymaster);
				
				return "PCD-product inventory updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}
	
}
