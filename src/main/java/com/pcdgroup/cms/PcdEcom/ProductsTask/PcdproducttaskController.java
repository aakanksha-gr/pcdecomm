package com.pcdgroup.cms.PcdEcom.ProductsTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PcdproducttaskController {

	@Autowired
	PcdproducttaskServiceImpl pcdproducttaskServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/createPcdproducttask")
	public String createPcdproducttask(@RequestBody Pcdproducttaskmaster pcdproducttaskmaster) {
	
		return pcdproducttaskServiceImpl.createPcdproducttask(pcdproducttaskmaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getPcdproducttask/{pcdproducttaskid}")
	public Pcdproducttaskmaster getPcdproducttask(@PathVariable Integer pcdproducttaskid) {
		
		return pcdproducttaskServiceImpl.getPcdproducttask(pcdproducttaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getPcdproducttaskByProductid/{pid}")
	public List<?> getPcdproducttaskByProductid(@PathVariable Integer pid) {
		
		return pcdproducttaskServiceImpl.getAlltaskByProductId(pid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllPcdproducttask")
	public List<?> getAllPcdproducttask() {
		
		return pcdproducttaskServiceImpl.getAllPcdproducttask();
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updatePcdproducttask/{pcdproducttaskid}")
	public String updatePcdproducttask(@RequestBody Pcdproducttaskmaster pcdproducttaskmaster, @PathVariable Integer pcdproducttaskid) {
		
		return pcdproducttaskServiceImpl.updatePcdproducttask(pcdproducttaskmaster, pcdproducttaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deletePcdproducttask/{pcdproducttaskid}")
	public String deletePcdproducttask(@PathVariable Integer pcdproducttaskid) {
		
		return pcdproducttaskServiceImpl.deletePcdproducttask(pcdproducttaskid);
		
	}
	
}
