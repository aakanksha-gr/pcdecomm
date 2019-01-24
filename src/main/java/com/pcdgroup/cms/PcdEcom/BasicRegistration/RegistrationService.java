package com.pcdgroup.cms.PcdEcom.BasicRegistration;

import java.util.List;
import java.util.Optional;

public interface RegistrationService {
	
	public List<Registermaster> getAllRegisteredUsers(int startindx);
	public  Optional<Registermaster> getUserById(Integer id);
	public Registermaster addUser(Registermaster registermaster, EmailMessageBean emailMessageBean);
	public String updateUser(Integer rid, Registermaster registermaster);
	public String deleteUser(Integer id);
	public Registermaster checkLogin(Registermaster registermaster); 
}
