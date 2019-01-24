package com.pcdgroup.cms.PcdEcom.PcdService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceController {

	@Autowired
	ServiceInterfaceImpl serviceInterfaceImpl;
	
	@RequestMapping(method=RequestMethod.GET, value="/viewAllService/{startindx}")
	public List<?> findAllPcdServices(@PathVariable int startindx) {
		
		return serviceInterfaceImpl.getAllPcdService(startindx);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewPcdServiceById/{serviceid}")
	public List<?> findPcdServiceById(@PathVariable int serviceid) {
		
		return serviceInterfaceImpl.getPcdServiceById(serviceid);
	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addPcdService")
	public void findPcdServiceById(@RequestBody Servicemaster servicemaster) {
		
		serviceInterfaceImpl.addPcdService(servicemaster);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatePcdService/{id}")
	public String updateProductById(@RequestBody Servicemaster servicemaster, @PathVariable Integer id) {
		
		return serviceInterfaceImpl.updateServiceById(servicemaster, id);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deletePcdServiceById/{serviceid}")
	public String deletePcdService(@PathVariable Integer serviceid) {
		
		return serviceInterfaceImpl.deletePcdService(serviceid);
		
	}
	
}
