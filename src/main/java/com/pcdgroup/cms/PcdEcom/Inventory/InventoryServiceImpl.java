package com.pcdgroup.cms.PcdEcom.Inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	InventoryRepository inventoryRepository;
	
	@Override
	public String createInventory(Inventorymaster inventorymaster) {
		
		try {
			
			if(null != inventoryRepository.getMaxId()) {
				
				inventorymaster.setInventoryid(inventoryRepository.getMaxId()+1);
				
			} else {
				
				inventorymaster.setInventoryid(1);
				
			}
			
			if( Integer.valueOf(inventorymaster.getInventorystock()) <= Integer.valueOf(inventorymaster.getInventorymimimumstock())) {
				
				inventorymaster.setInventorystockstatus("out of Stock");
				
			} else {
				
				inventorymaster.setInventorystockstatus("Stock avilable");
				
			}
			
			inventoryRepository.save(inventorymaster);
			
			return "Inventory created..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public Inventorymaster getInventory(Integer inventoryid) {
		
		try {
			
			if(null != inventoryid) {
				
				return inventoryRepository.getInventory(inventoryid);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<Inventorymaster> getAllInventory(Integer index) {
		
		try {
			
			if(null != inventoryRepository.getAllInventory(index) && inventoryRepository.getAllInventory(index).size() > 0) {
				
				return inventoryRepository.getAllInventory(index);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

	@Override
	public String deleteInventory(Integer inventoryid) {
		
		try {
			
			if(null != inventoryid) {
				
				if(null != inventoryRepository.getInventory(inventoryid)) {
					
					inventoryRepository.deleteById(inventoryid);
					
					return "Inventory removed..!";
					
				} else {
					
					return "No inventory is avilable with provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	
	}

	@Override
	public String updateInventory(Inventorymaster inventorymaster, Integer inventoryid) {
		
		try {
			
			if(null != inventoryid) {
				
				inventorymaster.setInventoryid(inventoryid);
				 
				if( Integer.valueOf(inventorymaster.getInventorystock()) <= Integer.valueOf(inventorymaster.getInventorymimimumstock())) {
					
					inventorymaster.setInventorystockstatus("out of Stock");
					
				} else {
					
					inventorymaster.setInventorystockstatus("Stock avilable");
					
				}
				
				inventoryRepository.save(inventorymaster);
			
				return "Inventory updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	
	}
	
	public String updateProductInventory( Inventorymaster inventorymaster,
			Integer inventoryid, String inventoryname, String inventorybrand, String inventorylocation,
			String inventoryquantity, String inventorymimimumstock, String inventoryhsncode, String inventorygst, 
			String inventorystock, Integer productquantity) {
		
		try {
		
			if(null != inventoryid) {
				
				inventorymaster.setInventoryid(inventoryid);
				
				if(null != inventoryname) {
					inventorymaster.setInventoryname(inventoryname);
				}
				
				if(null != inventorybrand) {
					inventorymaster.setInventorybrand(inventorybrand);
				}
				
				if(null != inventorylocation) {
					inventorymaster.setInventorylocation(inventorylocation);
				}
				
				if(null != inventoryquantity) {
					inventorymaster.setInventoryquantity(inventoryquantity);
				}

				if(null != inventorymimimumstock) {
					inventorymaster.setInventorymimimumstock(inventorymimimumstock);
				}
				
				if(Integer.parseInt(inventorystock) > productquantity) {
					
					inventorymaster.setInventorystock(String.valueOf(Integer.parseInt(inventorystock) - productquantity));
					
				} else {
					
					inventorymaster.setInventorystock(String.valueOf(productquantity - Integer.parseInt(inventorystock)));
					
				}
				
				if( Integer.valueOf(inventorymaster.getInventorystock()) <= Integer.valueOf(inventorymaster.getInventorymimimumstock())) {
					
					inventorymaster.setInventorystockstatus("out of stock");
					
				} else {
					
					inventorymaster.setInventorystockstatus("Stock avilable");
					
				}
				
				if(null != inventoryhsncode) {
					inventorymaster.setInventoryhsncode(inventoryhsncode);
				}
				
				if(null != inventorygst) {
					inventorymaster.setInventorygst(inventorygst);
				}
				
				inventoryRepository.save(inventorymaster);
			
				return "product inventory stock updated..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;

	}

	@Override
	public List<Inventorymaster> getAllOutofstockInventory() {
		
		try {
			
			if(null != inventoryRepository.getAllOutofstockInventory() && inventoryRepository.getAllOutofstockInventory().size() > 0 ) {
				
				return inventoryRepository.getAllOutofstockInventory();
				
			}
				
		} catch (Exception e) {
		
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<Inventorymaster> getAllInventoryByBrand(String brand) {
		
		try {
			
			if(null != brand && brand.trim().length() > 0) {
				
				return inventoryRepository.getAllInventoryByBrand(brand);
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

}
