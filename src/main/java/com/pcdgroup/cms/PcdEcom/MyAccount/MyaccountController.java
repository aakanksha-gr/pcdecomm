package com.pcdgroup.cms.PcdEcom.MyAccount;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyaccountController {
	
	@Autowired
	MyaccountServiceImpl myaccountServiceImpl;
	
	@RequestMapping(method=RequestMethod.GET, value="/viewMyDetails/{id}") 
	public List<?> viewMyDetails(@PathVariable Integer id) {
		return myaccountServiceImpl.viewMyAccountDetails(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/addMyDetails/{id}")
	public String addMyDetails(@RequestBody Myaccountmaster myaccountmaster, @PathVariable Integer id) {
		return myaccountServiceImpl.addMyDetails(myaccountmaster, id);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateMyDetails/{id}") 
	public String updateMyDetails(@RequestBody Myaccountmaster myaccountmaster, @PathVariable Integer id) {
		return myaccountServiceImpl.updateAccountDetails(myaccountmaster, id);
	}
	
}
