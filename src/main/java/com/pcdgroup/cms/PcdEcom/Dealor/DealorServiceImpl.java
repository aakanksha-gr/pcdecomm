package com.pcdgroup.cms.PcdEcom.Dealor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pcdgroup.cms.PcdEcom.BasicRegistration.Passwordsecurity;

@Service
public class DealorServiceImpl implements DealorService {

	@Autowired
	DealorRepository dealorRepository;
	
	Passwordsecurity passwordsecurity;
	
	@Override
	public Dealormaster dealorLogin(Dealormaster dealormaster) {
		
		try {
		
			passwordsecurity = new Passwordsecurity();
			
			if(null != dealormaster.getDealoremail() && null != dealormaster.getDealorpassword()) {
				
				return dealorRepository.checkDealorLogin(dealormaster.getDealoremail(), passwordsecurity.encrypt(dealormaster.getDealorpassword()));
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

	@Override
	public String addDealor(Dealormaster dealormaster) {
		
		try {
			
			passwordsecurity = new Passwordsecurity();
			
			if(null != dealorRepository.checkDuplicateEmail(dealormaster.getDealoremail())) {
				
				return "Email already exist, please try different..!";
				
			} else {
				
				if(null != dealorRepository.getMaxId()) {
					
					dealormaster.setDealorid(dealorRepository.getMaxId()+1);
					
				} else {
					
					dealormaster.setDealorid(1);
					
				}
				
				dealormaster.setDealorpassword(passwordsecurity.encrypt(dealormaster.getDealorpassword()));
				
				dealorRepository.save(dealormaster);
				
				return "Dealor created..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
	}

	@Override
	public String updateDealor(Dealormaster dealormaster, Integer dealorid) {
		
		try {
			
			passwordsecurity = new Passwordsecurity();
			
			if(null != dealorid) {
				
				if(null != dealorRepository.checkDuplicateEmail(dealormaster.getDealoremail(), dealorid)) {
					
					return "Email id already used by other employee..!";
					
				} else {
					
					dealormaster.setDealorid(dealorid);;
					
					dealormaster.setDealorpassword(dealormaster.getDealorpassword());
					
					dealorRepository.save(dealormaster);
					
					return "Dealor updated..!";
					
				}
				
			}	
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public Dealormaster getDealorDetails(Integer dealorid) {
		
		if(null != dealorid) {
			
			return dealorRepository.getDealorById(dealorid);
			
		}
		
		return null;
	}

	@Override
	public List<?> getAllDealorsDetails(Integer index) {
		
		List<Dealormaster> dealorsList;
		
		try {
			
			dealorsList = new ArrayList<>();
			
			dealorsList = dealorRepository.getAllDealors(index);
			
			if(null != dealorsList && dealorsList.size() > 0) {
				
				return dealorsList;
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

	@Override
	public String removeDealior(Integer dealorid) {	
		
		try {
		
			if(null != dealorid) {
				
				if(null != dealorRepository.getDealorById(dealorid)) {
					
					dealorRepository.deleteById(dealorid);
					
					return "Dealor removed..!";
					
				}
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return null;
	
	}

}
