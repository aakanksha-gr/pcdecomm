package com.pcdgroup.cms.PcdEcom.Dealor;

import java.util.List;

public interface DealorService {

	public String addDealor(Dealormaster dealormaster);
	public String updateDealor(Dealormaster dealormaster, Integer dealorid);
	public Dealormaster getDealorDetails(Integer dealorid);
	public List<?> getAllDealorsDetails(Integer index);
	public String removeDealior(Integer dealorid);
	Dealormaster dealorLogin(Dealormaster dealormaster);
	
}
