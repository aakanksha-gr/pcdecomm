package com.pcdgroup.cms.PcdEcom.Inventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InventoryController {
	
	@Autowired
	InventoryServiceImpl inventoryServiceImpl;

	@RequestMapping(method=RequestMethod.POST, value="/createInventory")
	public String createInventory(@RequestBody Inventorymaster inventorymaster) {
	
		return inventoryServiceImpl.createInventory(inventorymaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getInventory/{inventoryid}")
	public Inventorymaster getInventory(@PathVariable Integer inventoryid) {
		
		return inventoryServiceImpl.getInventory(inventoryid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllInventory/{index}")
	public List<?> getAllInventory(@PathVariable Integer index) {
		
		return inventoryServiceImpl.getAllInventory(index);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllInventoryByBrand/{brand}")
	public List<?> getAllInventoryByBrand(@PathVariable String brand) {
		
		return inventoryServiceImpl.getAllInventoryByBrand(brand);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateInventory/{inventoryid}")
	public String updateInventory(@RequestBody Inventorymaster inventorymaster, @PathVariable Integer inventoryid) {
		
		return inventoryServiceImpl.updateInventory(inventorymaster, inventoryid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteInventory/{inventoryid}")
	public String deleteInventory(@PathVariable Integer inventoryid) {
		
		return inventoryServiceImpl.deleteInventory(inventoryid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllOutofstockInventory")
	public List<?> getAllOutofstockInventory() {
		
		return inventoryServiceImpl.getAllOutofstockInventory();
		
	}
	
}
