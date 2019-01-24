package com.pcdgroup.cms.PcdEcom.ProductInventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DartproductinventoryController {

	@Autowired
	DartproductinventoryServiceImpl dartproductinventoryServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/createDartproductinventory")
	public String createDartproductinventory(@RequestBody Dartproductinventorymaster dartproductinventorymaster) {
	
		return dartproductinventoryServiceImpl.createDartproductInventory(dartproductinventorymaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getDartproductinventory/{dartproductinventoryid}")
	public Dartproductinventorymaster getDartproductinventory(@PathVariable Integer dartproductinventoryid) {
		
		return dartproductinventoryServiceImpl.getDartproductInventory(dartproductinventoryid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllDartproductinventory")
	public List<?> getAllDartproductinventory() {
		
		return dartproductinventoryServiceImpl.getAllDartproductInventories();
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateDartproductinventory/{dartproductinventoryid}")
	public String updateDartproductinventory(@RequestBody Dartproductinventorymaster dartproductinventorymaster, @PathVariable Integer dartproductinventoryid) {
		
		return dartproductinventoryServiceImpl.updateDartproductInventory(dartproductinventorymaster, dartproductinventoryid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteDartproductinventory/{dartproductinventoryid}")
	public String deleteDartproductinventory(@PathVariable Integer dartproductinventoryid) {
		
		return dartproductinventoryServiceImpl.deleteDartproductInventory(dartproductinventoryid);
		
	}
	
}
