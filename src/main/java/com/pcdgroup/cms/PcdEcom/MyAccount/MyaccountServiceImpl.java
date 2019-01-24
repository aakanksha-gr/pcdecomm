package com.pcdgroup.cms.PcdEcom.MyAccount;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyaccountServiceImpl implements MyaccountService {

	@Autowired
	MyaccountRepository myaccountRepository;
	
	@Override
	public List<?> viewMyAccountDetails(Integer id) {
		
		List<Myaccountmaster> mydetails;
		
		try {
		
			mydetails = new ArrayList<>();
			
			if(null != String.valueOf(id)) {
				mydetails = myaccountRepository.getMyAccountDetails(id);
				
				if(null != mydetails && mydetails.size() > 0) {
					return mydetails;
				}
				
			}
		
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
		
		}
		
		return null;
	}

	@Override
	public String addMyDetails(Myaccountmaster myaccountmaster, Integer id) {
		
		try {
			
			if(null != myaccountRepository.getMaxId()) {
				myaccountmaster.setMyaccountid(myaccountRepository.getMaxId()+1);
			} else {
				myaccountmaster.setMyaccountid(1);
			}
			
			myaccountmaster.setUserid(id);
			
			myaccountRepository.save(myaccountmaster);
			
			return "User details added..!";
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String updateAccountDetails(Myaccountmaster myaccountmaster, Integer id) {
	
		
		try {
		
			if(null != String.valueOf(id)) {
				//myaccountmaster.setMyaccountid(accountId);
				Integer rowid = myaccountRepository.getUpdateRowId(id);
				
				if(null != String.valueOf(rowid)) {
				
					myaccountmaster.setMyaccountid(rowid);
				
				}
				
				myaccountmaster.setUserid(id);
				myaccountRepository.save(myaccountmaster);
				
				return "User details updated..!";
			
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}

	@Override
	public String deleteMyAccountDetails(Integer id) {
		
		
		try {
		
			if(null != String.valueOf(id)) {
				
				myaccountRepository.getDeleteRowId(id);
				
				return "User details removed..!";
				
			}
			
		} catch (Exception e) {
			
			e.printStackTrace();
			System.out.println(e);
			
		}
		
		return "Something wents wrong..!";
		
	}
	
}
