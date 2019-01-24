package com.pcdgroup.cms.PcdEcom.BasicRegistration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegistrationController {
	
	@Autowired
	RegistrationServiceImpl registrationServiceImpl; 
	
	@RequestMapping(method=RequestMethod.POST, value="/loginuser")
	public Registermaster login(@RequestBody Registermaster registermaster) {
		
		//System.out.println(email);
		return registrationServiceImpl.checkLogin(registermaster);
	
	}
	
	@RequestMapping(method=RequestMethod.GET, value="/viewAllUsers/{startindx}")
	public List<?> findAll(@PathVariable int startindx) {

		return registrationServiceImpl.getAllRegisteredUsers(startindx);
	
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/addUsers")
	public Registermaster addUser(@RequestBody Registermaster registermaster, EmailMessageBean emailMessageBean) {
	
		return registrationServiceImpl.addUser(registermaster, emailMessageBean);
		
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value="/deleteUserById/{id}")
	public String removeUser(@PathVariable Integer id) {
	
		return registrationServiceImpl.deleteUser(id);
	
	}
	
	/*@RequestMapping(method=RequestMethod.GET, value="/viewUserById/{id}")
	public Optional<Registermaster> getUserById(@PathVariable Integer id) {
	
		return registrationServiceImpl.getUserById(id);
	
	}*/
	
	@RequestMapping(method=RequestMethod.PUT, value="/updateUser/{id}")
	public String updateUserById(@RequestBody Registermaster registermaster, @PathVariable Integer id) {
	
		return registrationServiceImpl.checkDuplicateEmail(id, registermaster);

	}
	
	@RequestMapping(method=RequestMethod.POST, value="/sendEmailAndMessage")
	public String sendEmailAndMessage(@RequestBody EmailMessageBean emailMessageBean) {
	
		//registrationServiceImpl.emailMessageBody(emailMessageBean);
		registrationServiceImpl.messageBody(emailMessageBean);
		
		return "OTP Sent successfully..!";
		
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/getList")
	public List<EmailMessageBean> getList(@RequestBody EmailMessageBean emailMessageBean) {
		registrationServiceImpl.getList(emailMessageBean);
		return null;
	}
	
}