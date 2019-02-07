package com.pcdgroup.cms.PcdEcom.Admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.BasicRegistration.Passwordsecurity;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminRepository adminRepository;
	
	Passwordsecurity passwordsecurity;
	
	public Adminmaster adminLogin(Adminmaster adminmaster) {
		
		try {
		
			passwordsecurity = new Passwordsecurity();
			
			if(null != adminRepository.checkAdminLogin(adminmaster.getAdminemail().toLowerCase().trim(), passwordsecurity.encrypt(adminmaster.getAdminpassword().toLowerCase().trim()))) {
				
				return adminRepository.checkAdminLogin(adminmaster.getAdminemail().toLowerCase().trim(), passwordsecurity.encrypt(adminmaster.getAdminpassword().toLowerCase().trim()));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
	public String createAdmin(Adminmaster adminmaster) {
		
		try {
			
			passwordsecurity = new Passwordsecurity();
			
			System.out.println(adminmaster.getAdminemail());
			
			if(null != adminRepository.checkDuplicateEmail(adminmaster.getAdminemail())) {
			
				return "Email id already used please try different..!";
				
			} else {
					
				if(null != adminRepository.getMaxId()) {
					
					adminmaster.setAdminid(adminRepository.getMaxId()+1);
					
				} else {
					
					adminmaster.setAdminid(1);
					
				}
				
				adminmaster.setAdminpassword(passwordsecurity.encrypt(adminmaster.getAdminpassword()));
				
				adminRepository.save(adminmaster);
				
				return "Admin created..!";	
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	public Adminmaster getAdmin(Integer adminid) {
		
		try {
			
			if(null != adminid) {
				
				return adminRepository.getAdminDetails(adminid);
				
			} 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}
	
	public List<Adminmaster> getAllAdmins() {
				
		try {
					
			if(null != adminRepository.getAllAdminsDetails()) {
					
				return adminRepository.getAllAdminsDetails();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	public String deleteAdmin(Integer adminid) {
		
		try {
		
			if(null != adminid) {
				
				if(null != adminRepository.checkDeleteIdExist(adminid)) {
					
					adminRepository.deleteById(adminid);
					
					return "Admin removed..!";
					
				} else {
					
					return "No admin avilable related to provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
			
		return "Something wents wrong..!";
		
	}

	public String updateAdmin(Adminmaster adminmaster, Integer adminid) {
		
		try {
			
			if(null != adminid) {
				
				if(null != adminRepository.checkDuplicateEmail(adminmaster.getAdminemail(), adminid)) {
					
					return "Email id already in used by other admin..!";
					
				} else {
					
					adminmaster.setAdminid(adminid);
					
					//adminmaster.setAdminpassword(passwordsecurity.encrypt(adminmaster.getAdminpassword()));
					
					adminRepository.save(adminmaster);
					
					return "Admin Updated..!";
					
				}
				
			} 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}
	
}
