package com.pcdgroup.cms.PcdEcom.MyAccount;

import java.util.List;

public interface MyaccountService {

	List<?> viewMyAccountDetails(Integer id);
	public String addMyDetails(Myaccountmaster myaccountmaster, Integer id);
	public String updateAccountDetails(Myaccountmaster myaccountmaster, Integer id);
	public String deleteMyAccountDetails(Integer id);
	
	
}
