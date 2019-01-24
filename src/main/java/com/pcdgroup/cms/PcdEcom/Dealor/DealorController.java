package com.pcdgroup.cms.PcdEcom.Dealor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DealorController {

	@Autowired
	DealorServiceImpl dealorServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/dealorLogin")
	public Dealormaster dealorLogin(@RequestBody Dealormaster dealormaster) {
		return dealorServiceImpl.dealorLogin(dealormaster);
	}
	
	@RequestMapping(method=RequestMethod.POST , value="/createDealor")
	public String createDealor(@RequestBody Dealormaster dealormaster) {
		return dealorServiceImpl.addDealor(dealormaster);
	}

	@RequestMapping(method=RequestMethod.PUT , value="/updateDealor/{dealorid}")
	public String updateDealor(@RequestBody Dealormaster dealormaster, @PathVariable Integer dealorid) {
		return dealorServiceImpl.updateDealor(dealormaster, dealorid);
	}
	
	@RequestMapping(method=RequestMethod.DELETE , value="/removeDealor/{dealorid}")
	public String removeDealor(@PathVariable Integer dealorid) {
		return dealorServiceImpl.removeDealior(dealorid);
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/getDealorById/{dealorid}")
	public Dealormaster getDealorById(@PathVariable Integer dealorid) {
		return dealorServiceImpl.getDealorDetails(dealorid);
	}
	
	@RequestMapping(method=RequestMethod.GET , value="/getAllDealors/{index}")
	public List<?> getAllDealors(@PathVariable Integer index) {
		return dealorServiceImpl.getAllDealorsDetails(index);
	}
	
}
