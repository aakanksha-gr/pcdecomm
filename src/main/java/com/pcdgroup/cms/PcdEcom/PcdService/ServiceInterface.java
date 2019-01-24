package com.pcdgroup.cms.PcdEcom.PcdService;

import java.util.List;

public interface ServiceInterface {
	
	public List<?> getAllPcdService(int startindx);
	public List<?> getPcdServiceById(Integer serviceid);
	public String addPcdService(Servicemaster servicemaster);
	public String updateServiceById(Servicemaster servicemaster, Integer id);
	public String deletePcdService(Integer serviceid);

}
