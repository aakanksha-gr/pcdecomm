package com.pcdgroup.cms.PcdEcom.ServicesTask;

import java.util.List;

public interface DartservicetaskService {

	public String createDartserviceTask(Dartservicetaskmaster dartservicetaskmaster);
	public Dartservicetaskmaster getDartserviceTask(Integer dartservicetaskid);
	public List<Dartservicetaskmaster> getAllDartserviceTasks();
	public String deleteDartserviceTask(Integer dartservicetaskid);
	public String updateDartserviceTask(Dartservicetaskmaster dartservicetaskmaster, Integer dartservicetaskid);
	public List<?> getDartserviceTaskByServiceid(Integer dartserviceid);
	
}
