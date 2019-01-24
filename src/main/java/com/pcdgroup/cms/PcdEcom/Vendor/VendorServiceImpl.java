package com.pcdgroup.cms.PcdEcom.Vendor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.BasicRegistration.Passwordsecurity;

@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	VendorRepository vendorRepository;
	
	Passwordsecurity passwordsecurity;

	@Override
	public String createVendor(Vendormaster vendormaster) {
		
		try {
			
			passwordsecurity = new Passwordsecurity();
				
			if(null != vendorRepository.checkDuplicateEmail(vendormaster.getVendoremail())) {
			
				return "Email id already used please try different..!";
				
			} else {
					
				if(null != vendorRepository.getMaxId()) {
					
					vendormaster.setVendorid(vendorRepository.getMaxId()+1);
					
				} else {
					
					vendormaster.setVendorid(1);
					
				}
				
				vendormaster.setVendorpassword(passwordsecurity.encrypt(vendormaster.getVendorpassword()));
				
				vendorRepository.save(vendormaster);
				
				return "Vendor created..!";	
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	}

	@Override
	public Vendormaster getVendor(Integer vendorid) {
		
		try {
			
			if(null != vendorid) {
				
				return vendorRepository.getVendorDetails(vendorid);
				
			} 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public List<Vendormaster> getAllVendors() {
		
		try {
			
			if(null != vendorRepository.getAllVendorsDetails()) {
					
				return vendorRepository.getAllVendorsDetails();
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	}

	@Override
	public String deleteVendor(Integer vendorid) {

		try {
			
			if(null != vendorid) {
				
				if(null != vendorRepository.checkDeleteIdExist(vendorid)) {
					
					vendorRepository.deleteById(vendorid);;
					
					return "Vendor removed..!";
					
				} else {
					
					return "No Vendor avilable related to provided id..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
			
		return "Something wents wrong..!";
		
	}

	@Override
	public String updateVendor(Vendormaster vendormaster, Integer vendorid) {
		
		try {
			
			if(null != vendorid) {
				
				if(null != vendorRepository.checkDuplicateEmail(vendormaster.getVendoremail(), vendorid)) {
					
					return "Email id already in used by other Vendor..!";
					
				} else {
					
					vendormaster.setVendorid(vendorid);
					
					if(null != vendormaster.getVendorpassword()) {
						
						vendormaster.setVendorpassword(passwordsecurity.encrypt(vendormaster.getVendorpassword()));
						
					}
					
					vendorRepository.save(vendormaster);
					
					return "Vendor Updated..!";
					
				}
				
			} 
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}
	
}
