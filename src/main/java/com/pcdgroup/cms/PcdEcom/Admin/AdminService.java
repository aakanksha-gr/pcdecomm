package com.pcdgroup.cms.PcdEcom.Admin;

import java.util.List;

public interface AdminService {
	
	public String createAdmin(Adminmaster adminmaster);
	public Adminmaster getAdmin(Integer adminid);
	public List<Adminmaster> getAllAdmins();
	public String deleteAdmin(Integer adminid);
	public String updateAdmin(Adminmaster adminmaster, Integer adminid);
	public String adminLogin(Adminmaster adminmaster);
	
}
