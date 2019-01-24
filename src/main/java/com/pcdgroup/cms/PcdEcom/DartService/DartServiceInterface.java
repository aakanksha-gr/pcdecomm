package com.pcdgroup.cms.PcdEcom.DartService;

import java.util.List;

public interface DartServiceInterface {
	
	public List<?> getAllDartService(int startindx);
	public List<?> getDartServiceById(Integer serviceid);
	public String addPcdService(Dartservicemaster dartservicemaster);
	public String updateServiceById(Dartservicemaster dartservicemaster, Integer id);
	public String deleteDartService(Integer serviceid);

}