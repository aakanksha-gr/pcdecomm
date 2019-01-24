package com.pcdgroup.cms.PcdEcom.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

	@Autowired
	AdminServiceImpl adminServiceImpl;
	
	@RequestMapping(method=RequestMethod.POST, value="/adminLogin")
	public Adminmaster adminLogin(@RequestBody Adminmaster adminmaster) {
		
		return adminServiceImpl.adminLogin(adminmaster);
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addAdmin")
	public String addAdmin(@RequestBody Adminmaster adminmaster) {
		
		return adminServiceImpl.createAdmin(adminmaster);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAdmin/{adminid}")
	public Adminmaster getAdmin(@PathVariable Integer adminid) {
		
		return adminServiceImpl.getAdmin(adminid);
		
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/getAllAdmins")
	public List<Adminmaster> getAllAdmins() {
		
		return adminServiceImpl.getAllAdmins();
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteAdmin/{adminid}")
	public String deleteAdmin(@PathVariable Integer adminid) {
		
		return adminServiceImpl.deleteAdmin(adminid);
		
	}
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateAdmin/{adminid}")
	public String updateAdmin(@RequestBody Adminmaster adminmaster, @PathVariable Integer adminid) {
		
		return adminServiceImpl.updateAdmin(adminmaster, adminid);
		
	}
	
}
