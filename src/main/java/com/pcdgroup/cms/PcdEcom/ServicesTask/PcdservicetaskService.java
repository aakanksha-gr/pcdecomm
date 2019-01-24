package com.pcdgroup.cms.PcdEcom.ServicesTask;

import java.util.List;

public interface PcdservicetaskService {

	public String createPcdserviceTask(Pcdservicetaskmaster pcdservicetaskmaster);
	public Pcdservicetaskmaster getPcdserviceTask(Integer pcdservicetaskid);
	public List<Pcdservicetaskmaster> getAllPcdserviceTasks();
	public String deletePcdserviceTask(Integer pcdservicetaskid);
	public String updatePcdserviceTask(Pcdservicetaskmaster pcdservicetaskmaster, Integer pcdservicetaskid);
	List<?> getPcdserviceTaskByServiceid(Integer pcdserviceid);
	
}
