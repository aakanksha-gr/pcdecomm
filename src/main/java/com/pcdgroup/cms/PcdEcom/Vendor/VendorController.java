package com.pcdgroup.cms.PcdEcom.Vendor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VendorController {

	@Autowired
	VendorServiceImpl vendorServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/createVendor")
	public String createVendor(@RequestBody Vendormaster vendormaster) {
	
		return vendorServiceImpl.createVendor(vendormaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getVendor/{vendorid}")
	public Vendormaster getVendor(@PathVariable Integer vendorid) {
		
		return vendorServiceImpl.getVendor(vendorid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllVendors")
	public List<?> getAllVendors() {
		
		return vendorServiceImpl.getAllVendors();
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateVendor/{vendorid}")
	public String updateVendor(@RequestBody Vendormaster vendormaster, @PathVariable Integer vendorid) {
		
		return vendorServiceImpl.updateVendor(vendormaster, vendorid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteVendor/{vendorid}")
	public String deleteVendor(@PathVariable Integer vendorid) {
		
		return vendorServiceImpl.deleteVendor(vendorid);
		
	}
	
}
