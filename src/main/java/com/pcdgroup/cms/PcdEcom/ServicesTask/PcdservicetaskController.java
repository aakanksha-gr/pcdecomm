package com.pcdgroup.cms.PcdEcom.ServicesTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PcdservicetaskController {

	@Autowired
	PcdservicetaskServiceImpl pcdservicetaskServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/createPcdservicetask")
	public String createPcdservicetask(@RequestBody Pcdservicetaskmaster pcdservicetaskmaster) {
	
		return pcdservicetaskServiceImpl.createPcdserviceTask(pcdservicetaskmaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getPcdservicetask/{pcdservicetaskid}")
	public Pcdservicetaskmaster getPcdservicetask(@PathVariable Integer pcdservicetaskid) {
		
		return pcdservicetaskServiceImpl.getPcdserviceTask(pcdservicetaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getPcdservicetaskByServiceid/{pcdserviceid}")
	public List<?> getPcdservicetaskByServiceid(@PathVariable Integer pcdserviceid) {
		
		return pcdservicetaskServiceImpl.getPcdserviceTaskByServiceid(pcdserviceid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllPcdservicetask")
	public List<?> getAllPcdservicetask() {
		
		return pcdservicetaskServiceImpl.getAllPcdserviceTasks();
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatePcdservicetask/{pcdservicetaskid}")
	public String updatePcdservicetask(@RequestBody Pcdservicetaskmaster pcdservicetaskmaster, @PathVariable Integer pcdservicetaskid) {
		
		return pcdservicetaskServiceImpl.updatePcdserviceTask(pcdservicetaskmaster, pcdservicetaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deletePcdservicetask/{pcdservicetaskid}")
	public String deletePcdproducttask(@PathVariable Integer pcdservicetaskid) {
		
		return pcdservicetaskServiceImpl.deletePcdserviceTask(pcdservicetaskid);
		
	}
	
}
