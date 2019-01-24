package com.pcdgroup.cms.PcdEcom.Dealor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DealorServiceImpl implements DealorService {

	@Autowired
	DealorRepository dealorRepository;

	@Override
	public String addDealor(Dealormaster dealormaster) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String updateDealor(Dealormaster dealormaster, Integer dealorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dealormaster getDealorDetails(Integer dealorid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dealormaster> getAllDealorsDetails() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String removeDealior(Integer dealorid) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
