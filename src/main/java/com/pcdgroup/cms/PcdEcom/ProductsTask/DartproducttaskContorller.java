package com.pcdgroup.cms.PcdEcom.ProductsTask;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DartproducttaskContorller {

	@Autowired
	DartproducttaskServiceImpl dartproducttaskServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/createDartproducttask")
	public String createDartproducttask(@RequestBody Dartproducttaskmaster dartproducttaskmaster) {
	
		return dartproducttaskServiceImpl.createDartproducttask(dartproducttaskmaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getDartproducttask/{dartproducttaskid}")
	public Dartproducttaskmaster getDartproducttask(@PathVariable Integer dartproducttaskid) {
		
		return dartproducttaskServiceImpl.getDartproducttask(dartproducttaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getDartproducttaskByProductid/{dartproductid}")
	public List<?> getDartproducttaskByProductid(@PathVariable Integer dartproductid) {
		
		return dartproducttaskServiceImpl.getDartproducttaskByProductid(dartproductid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllDartproducttask")
	public List<?> getAllDartproducttask() {
		
		return dartproducttaskServiceImpl.getAllDartproducttask();
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateDartproducttask/{dartproducttaskid}")
	public String updateDartproducttask(@RequestBody Dartproducttaskmaster dartproducttaskmaster, @PathVariable Integer dartproducttaskid) {
		
		return dartproducttaskServiceImpl.updateDartproducttask(dartproducttaskmaster, dartproducttaskid);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteDartproducttask/{dartproducttaskid}")
	public String deleteDartproducttask(@PathVariable Integer dartproducttaskid) {
		
		return dartproducttaskServiceImpl.deleteDartproducttask(dartproducttaskid);
		
	}
	
}
