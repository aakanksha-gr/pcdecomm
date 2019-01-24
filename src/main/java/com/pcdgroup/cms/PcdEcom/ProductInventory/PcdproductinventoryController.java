package com.pcdgroup.cms.PcdEcom.ProductInventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class PcdproductinventoryController {

	@Autowired
	PcdproductinventoryServiceImpl productinventoryServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/createPcdproductinventory")
	public String createPcdproductinventory(@RequestBody Pcdproductinventorymaster pcdproductinventorymaster) {
	
		return productinventoryServiceImpl.createProductInventory(pcdproductinventorymaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getPcdproductinventory/{pcdproductinventoryid}")
	public Pcdproductinventorymaster getPcdproductinventory(@PathVariable Integer pcdproductinventoryid) {
		
		return productinventoryServiceImpl.getProductInventory(pcdproductinventoryid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllPcdproductinventory")
	public List<?> getAllPcdproductinventory() {
		
		return productinventoryServiceImpl.getAllProductInventories();
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatePcdproductinventory/{pcdproductinventoryid}")
	public String updatePcdproductinventory(@RequestBody Pcdproductinventorymaster pcdproductinventorymaster, @PathVariable Integer pcdproductinventoryid) {
		
		return productinventoryServiceImpl.updateProductInventory(pcdproductinventorymaster, pcdproductinventoryid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deletePcdproductinventory/{pcdproductinventoryid}")
	public String deletePcdproductinventory(@PathVariable Integer pcdproductinventoryid) {
		
		return productinventoryServiceImpl.deleteProductInventory(pcdproductinventoryid);
		
	}
	
}
