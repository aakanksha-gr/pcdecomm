package com.pcdgroup.cms.PcdEcom.ServicesTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DartservicetaskController {

	@Autowired
	DartservicetaskServiceImpl dartservicetaskServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/createDartservicetask")
	public String createDartservicetask(@RequestBody Dartservicetaskmaster dartservicetaskmaster) {
	
		return dartservicetaskServiceImpl.createDartserviceTask(dartservicetaskmaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getDartservicetask/{dartservicetaskid}")
	public Dartservicetaskmaster getDartservicetask(@PathVariable Integer dartservicetaskid) {
		
		return dartservicetaskServiceImpl.getDartserviceTask(dartservicetaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getDartservicetaskByServiceid/{dartserviceid}")
	public List<?> getDartservicetaskByServiceid(@PathVariable Integer dartserviceid) {
		
		return dartservicetaskServiceImpl.getDartserviceTaskByServiceid(dartserviceid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllDartservicetask")
	public List<?> getAllDartservicetask() {
		
		return dartservicetaskServiceImpl.getAllDartserviceTasks();
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateDartservicetask/{dartservicetaskid}")
	public String updateDartservicetask(@RequestBody Dartservicetaskmaster dartservicetaskmaster, @PathVariable Integer dartservicetaskid) {
		
		return dartservicetaskServiceImpl.updateDartserviceTask(dartservicetaskmaster, dartservicetaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteDartservicetask/{dartservicetaskid}")
	public String deleteDartservicetask(@PathVariable Integer dartservicetaskid) {
		
		return dartservicetaskServiceImpl.deleteDartserviceTask(dartservicetaskid);
		
	}
	
}
