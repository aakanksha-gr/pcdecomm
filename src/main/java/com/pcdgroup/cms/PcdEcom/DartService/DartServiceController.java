package com.pcdgroup.cms.PcdEcom.DartService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DartServiceController {

	@Autowired
	DartServiceInterfaceImpl dartServiceInterfaceImpl;
	
	@RequestMapping(method=RequestMethod.GET, value="/viewAllDartService/{strtIndx}")
	public List<?> findAllDertProduct(@PathVariable int strtIndx) {
		
		return dartServiceInterfaceImpl.getAllDartService(strtIndx);
	
	}

	@RequestMapping(method=RequestMethod.GET, value="/viewDartServiceById/{serviceid}")
	public List<?> findDartServiceById(@PathVariable Integer serviceid) {
		
		return dartServiceInterfaceImpl.getDartServiceById(serviceid);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addDartService")
	public void findPcdServiceById(@RequestBody Dartservicemaster dartservicemaster) {
		
		dartServiceInterfaceImpl.addPcdService(dartservicemaster);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateDartService/{id}")
	public String updateProductById(@RequestBody Dartservicemaster dartservicemaster, @PathVariable Integer id) {
		
		return dartServiceInterfaceImpl.updateServiceById(dartservicemaster, id);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteDartServiceById/{serviceid}")
	public String deleteDartService(@PathVariable Integer serviceid) {
		
		return dartServiceInterfaceImpl.deleteDartService(serviceid);
		
	}
	
}
