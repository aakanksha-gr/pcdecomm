package com.pcdgroup.cms.PcdEcom.Vendorinventory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorinventoryController {

	@Autowired
	VendorinventoryServiceImpl vendorinventoryServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/createVendorinventory")
	public String Vendorinventory(@RequestBody Vendorinventorymaster vendorinventorymaster) {
	
		return vendorinventoryServiceImpl.createVendorinventory(vendorinventorymaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getVendorinventory/{vendorinventoryid}")
	public Vendorinventorymaster getVendorinventory(@PathVariable Integer vendorinventoryid) {
		
		return vendorinventoryServiceImpl.getVendorinventory(vendorinventoryid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getVendorinventoryByVendorId/{vendorid}")
	public List<?> getVendorinventoryByVendorid(@PathVariable Integer vendorid) {
		
		return vendorinventoryServiceImpl.getVendorinventoryByVendorId(vendorid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllVendorinventory/{index}")
	public List<?> getAllVendorinventory(@PathVariable Integer index) {
		
		return vendorinventoryServiceImpl.getAllVendorinventory(index);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateVendorinventory/{vendorinventoryid}")
	public String updateVendorinventory(@RequestBody Vendorinventorymaster vendorinventorymaster, @PathVariable Integer vendorinventoryid) {
		
		return vendorinventoryServiceImpl.updateVendorinventory(vendorinventorymaster, vendorinventoryid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteVendorinventory/{vendorinventoryid}")
	public String deleteVendorinventory(@PathVariable Integer vendorinventoryid) {
		
		return vendorinventoryServiceImpl.deleteVendorinventory(vendorinventoryid);
		
	}
	
}
